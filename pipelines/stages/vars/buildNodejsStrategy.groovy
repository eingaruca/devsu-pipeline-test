def call() {
    withFolderProperties {
        utils.info "BuildStage", "Starting NodeJS Strategy"
        // utils.info "BuildStage", "Workspace: ${env.WORKSPACE}"

        // Define Docker image
        def image = "node:20-alpine3.18"
        def node = docker.image(image)
        // Execute commands inside Docker container
        node.inside {
            sh "node --version"
            sh "npm --version"
            sh "npm install"
        }
        // Make stash to use in other stages
        stash name: 'build' 
        utils.info "BuildStage", "Finish NodeJS Strategy"
    }
}