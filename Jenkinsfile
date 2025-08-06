pipeline {
	agent {
		label 'jenkins-agent'
	}

	tools {
		jdk 'java17'
		maven 'maven3'
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
	}
}