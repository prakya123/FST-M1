node {

    stage('Checkout') {
        git url: 'https://github.com/prakya123/FST-M1.git', branch: 'main'
    }

    stage('Compile Java') {
        sh 'javac -cp libs/*:. *.java'
    }

    stage('Run TestNG') {
        sh 'java -cp libs/*:. org.testng.TestNG testng.xml'
    }
}
