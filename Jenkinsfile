@Library('my-library') _

pipeline {
    agent any

    stages {
        stage('Test Shared Library') {
            steps {
                script {
                    // Call your custom library functions directly
                    sayHello()
                    buildInfo()
                }
            }
        }
    }
}
