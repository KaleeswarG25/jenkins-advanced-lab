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
                bat 'hostname'
                bat 'whoami'
                bat 'date /t'
            }
        }

        stage('Variables') {
            steps {
                bat 'echo %APP_NAME%'
                // Challenge 2 & 3: Print all env vars and specific Jenkins ones
                bat 'set'
                bat 'echo Current Build: %BUILD_NUMBER%'
                bat 'echo Job Name: %JOB_NAME%'
                bat 'echo Workspace Path: %WORKSPACE%'
            }
        }

        stage('Workspace') {
            steps {
                // Challenge 1: Print workspace path and list files
                bat 'cd'
                bat 'dir'
            }
        }

        stage('Create Artifact') {
            steps {
                // DevOps Task: Create directory and write a file
                bat '''
                if not exist build mkdir build
                echo CloudCart Build > build\\app.txt
                dir build
                '''
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
