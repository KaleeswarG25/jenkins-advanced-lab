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
                // Changed from 'sh' to 'bat' for Windows compatibility
                bat 'hostname'
                bat 'whoami'
                bat 'date /t'
            }
        }
        stage('Variables') {
            steps {
                // Windows uses %VARIABLE% instead of $VARIABLE
                bat 'echo %APP_NAME%'
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
