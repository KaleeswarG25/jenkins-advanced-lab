pipeline {
    agent any
    environment {
        APP_NAME = "cloudcart"
    }
    parameters {
        choice(
            name: 'ENV',
            choices: ['dev','qa','prod'],
            description: 'Choose Environment'
        )
    }
    stages {
        stage('System Info') {
            steps {
                sh 'hostname'
                sh 'whoami'
                sh 'date'
            }
        }
        stage('Variables') {
            steps {
                sh 'echo $APP_NAME'
            }
        }
        stage('Environment Check') {
            steps {
                echo "Selected Environment: ${params.ENV}"
            }
        }
    }
    post {
        success {
            echo 'Build Successful'
        }
        failure {
            echo 'Build Failed'
        }
        always {
            echo 'Always Executed'
        }
    }
}
