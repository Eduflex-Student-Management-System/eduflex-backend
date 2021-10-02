pipeline {
    agent any
    stages {
        stage('Compile and Clean') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('deploy') {
            steps {
                sh "mvn package"
            }
        }

        stage('Build Docker image'){
            steps {
                bat 'docker build -t  akshaysargar/eduflex-backend:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login'){
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    bat "docker login -u akshaysargar -p ${Dockerpwd}"
                }
            }
        }

        stage('Docker Push'){
            steps {
                bat 'docker push akshaysargar/eduflex-backend:${BUILD_NUMBER}'
            }
        }

        stage('Docker deploy'){
            steps {
                bat 'docker run -itd -p  8081:8080 akshaysargar/eduflex-backend:${BUILD_NUMBER}'
            }
        }


        stage('Archiving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}
