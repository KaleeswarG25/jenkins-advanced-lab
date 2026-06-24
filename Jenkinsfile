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
                      def config = globalConfig()

                    // 2. Extract and assign properties to local variables
                    def appPort = config.APP_PORT
                    def imageRegistry = config.REGISTRY_DOMAIN
                    def contactInfo = config.MAINTAINER_EMAIL

                    // 3. Print out properties to confirm extraction works flawlessly
                    bat "echo [CONFIG LOADED] Deploying on Port: ${appPort}"
                    bat "echo [CONFIG LOADED] Registry Target: ${imageRegistry}"
                    bat "echo [CONFIG LOADED] Support Reference: ${contactInfo}"
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
