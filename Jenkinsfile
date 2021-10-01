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

                sh 'docker build -t  lala14/eduflex-backend:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login'){

            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u lala14 -p ${Dockerpwd}"
                }
            }
        }

        stage('Docker Push'){
            steps {
                sh 'docker push lala14/eduflex-backend:${BUILD_NUMBER}'
            }
        }

        stage('Docker deploy'){
            steps {

                sh 'docker run -itd -p  8081:8080 lala14/eduflex-backend:${BUILD_NUMBER}'
            }
        }


        stage('Archving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}
