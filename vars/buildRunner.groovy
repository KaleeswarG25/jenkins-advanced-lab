def call(Map args) {
    // 1. Assign defaults if a key is missing from the pipeline map
    def appName = args.name ?: "default-app"
    def targetEnv = args.env ?: "dev"
    def enableLogs = args.debug != null ? args.debug : false

    bat "echo =========================================="
    bat "echo 🏭 RUNNING NAMED-MAP PIPELINE FOR: ${appName}"
    bat "echo =========================================="
    bat "echo Target Target: ${targetEnv}"

    // 2. Perform conditional execution based on map configurations
    if (enableLogs) {
        bat "echo [DEBUG MODE ACTIVE] Gathering extended environment information..."
        bat "set"
    } else {
        bat "echo [INFO] Debug mode disabled. Skipping environment dump."
    }
}
