pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/prakya123/FST-M1.git'
            }
        }

        stage('Build & Test') {
            steps {
                dir('FST-M1') {   // <--- IMPORTANT: run Maven inside the folder that has pom.xml
                    sh 'mvn clean test'
                }
            }
        }
    }

    post {
        always {
            dir('FST-M1') {   // <--- report also inside same directory
                junit '**/surefire-reports/*.xml'
            }
        }
    }
}
