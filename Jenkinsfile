@Library('my-library') _

pipeline {
    agent any

    parameters {
        choice(
            name: 'ENV',
            choices: ['dev', 'qa', 'prod'],
            description: 'Select Target Environment'
        )
    }

    stages {
        stage('Map-Based Library Test') {
            steps {
                script {
                    // Practice: Passing explicit key-value arguments instead of array positions
                    buildRunner(
                        name: "cloudcart-api",
                        env: params.ENV,
                        debug: true
                    )
                }
            }
        }
    }
}
