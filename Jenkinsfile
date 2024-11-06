pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build JAR'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Saki-2002/PrestaBanco']])
                bat "mvn clean package"
            }
        }

        stage('Unit Tests') {
            steps {
                bat "mvn test"
            }
        }
		
        stage('Push image to Docker Hub'){
            steps{
                script{
                   withDockerRegistry(credentialsId:'docker-credentials'){
					bat "docker build -t saki2002/spring-image ."
					bat "docker push saki2002/spring-image"
				   }
                }
            }
        }
    }
}