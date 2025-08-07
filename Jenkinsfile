pipeline {
	agent {
		label 'jenkins-agent'
	}

	tools {
		jdk 'java17'
		maven 'maven3'
	}

	environment {
		APP_NAME = "world_airlines"
		RELEASE = "1.0.0"
		RELEASE_TAG = "${RELEASE}-${BUILD_NUMBER}" // include jenkins build number in image tag
	}

	stages {
		stage('Workspace cleanup') {
			steps {
				cleanWs ()
			}
		}

		stage ('Checkout github repository') {
			steps {
				git branch : 'master' ,
				credentialsId : 'github' ,
				url : 'https://github.com/Cassiopea2103/javaee_world_airlines'
			}
		}

		stage ("Build application") {
			steps {
				sh 'mvn clean package'
			}
		}

		stage ("Test application") {
			steps {
				sh 'mvn test'
			}
		}


	    stage ("SonarQube analysis") {
			steps {
				script {
					withSonarQubeEnv(credentialsId : 'sonarqube_jenkins_token') {
						sh 'mvn sonar:sonar'
					}
				}
			}
		}


		stage ("Quality Gate") {
			steps {
				script {
					waitForQualityGate abortPipeline: true , credentialsId : 'sonarqube_jenkins_token'
				}
			}
		}

		stage ("Docker build & push" ) {
			steps {
				script {
					withCredentials ([usernamePassword(
					    credentialsId : 'dockerhub' ,
					    usernameVariable : 'DOCKERHUB_USERNAME' ,
					    passwordVariable : 'DOCKERHUB_PASSWORD'
					)]) {
						// define image name variable :
						def IMAGE_NAME = "${DOCKERHUB_USERNAME}/${APP_NAME}"

						// build docker image with release tag:
						sh "docker build -t ${IMAGE_NAME}:${RELEASE_TAG} ."

						// login to dockerhub :
						sh "printf '%s' ${DOCKERHUB_PASSWORD} | docker login -u ${DOCKERHUB_USERNAME} --password-stdin"

						// create both release and latest tags for the image :
						sh "docker tag ${IMAGE_NAME}:${RELEASE_TAG} ${IMAGE_NAME}:latest"

						// push image to dockerhub with both tags :
						sh "docker push ${IMAGE_NAME}:${RELEASE_TAG}"
						sh "docker push ${IMAGE_NAME}:latest"
					}
				}
			}
		}

		stage ("Trivy image scan") {
			steps {
				script {

					def IMAGE_NAME = "${DOCKERHUB_USERNAME}/${APP_NAME}:latest"
					sh """
						docker run --rm \
						-v /var/run/docker.sock : /var/run/docker.sock \
						aquasec/trivy:latest image ${IMIAGE_NAME} \
						--no-progress \
						--scanners vuln \
						--severity HIGH,CRITICAL \
						--exit-code 1 \
					"""
				}
			}
		}

	    stage ("Docker cleanup & logout" ) {
			steps {
				script {
					// remove all local docker images :
					sh 'docker rmi $(docker images -q) || true'

					// logout from dockerhub :
					sh 'docker logout'
				}
			}
		}
	}
}