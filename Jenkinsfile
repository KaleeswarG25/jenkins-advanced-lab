@Library('my-library') _

pipeline {
    agent any

    parameters {
        choice(
            name: 'ENV',
            choices: ['dev','qa','prod'],
            description: 'Select Target Environment'
        )
    }

    stages {
        stage('Shared Library Deployment') {
            steps {
                script {
                    // Practice: Passing parameters into the shared library function
                    deployApp("cloudcart", params.ENV)
                }
            }
        }
    }
}
