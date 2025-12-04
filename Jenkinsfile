node {

    stage('Checkout') {
        git url: 'https://github.com/prakya123/FST-M1.git', branch: 'main'
    }

    stage('Build & Test') {
        sh 'mvn clean test'
    }

    stage('Publish TestNG Results') {
        junit '**/test-output/testng-results.xml'
        archiveArtifacts artifacts: 'test-output/**/*', fingerprint: true
    }
}
