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
                bat 'echo Current Build: %BUILD_NUMBER%'
                bat 'echo Job Name: %JOB_NAME%'
                bat 'echo Workspace Path: %WORKSPACE%'
            }
        }

        stage('Workspace') {
            steps {
                bat 'cd'
                bat 'dir'
            }
        }

        stage('Create Artifact') {
            steps {
                bat '''
                if not exist build mkdir build
                echo CloudCart Build > build\\app.txt
                dir build
                '''
            }
        }

        // NEW: Production Deployment Stage with Human Approval Gate
        stage('Deploy to Production') {
            // This stage will only run if the user chose 'prod' in the parameters
            when {
                expression { return params.ENV == 'prod' }
            }
            steps {
                echo "🚨 CRITICAL: Requesting production deployment clearance..."

                // Interactive prompt that pauses the entire pipeline
                input message: 'Do you want to approve deploying this artifact to Production?', ok: 'Deploy Now!'

                echo "🚀 Deploying artifact app.txt to Production environment..."
                bat 'echo [PROD DEPLOY DONE] > build\\deploy_status.txt'
            }
        }
    }

    post {
        success { echo 'Build Successful' }
        failure { echo 'Build Failed' }
        always  { echo 'Always Executed' }
    }
}
