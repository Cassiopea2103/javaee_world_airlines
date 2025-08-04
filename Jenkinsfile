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
				git branch : 'main' ,
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
	}
}