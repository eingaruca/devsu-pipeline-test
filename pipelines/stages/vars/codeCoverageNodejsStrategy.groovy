def call() {
    withFolderProperties {
        utils.info "CodeCoverageStage", "Node.js Strategy"

        // Define Docker image
        def image = "node:20-alpine3.18"
        def node = docker.image(image)

        // Execute commands inside Docker container
        node.inside {
            unstash name: 'build'
            sh "npm install" 
            // sh "npm run test"

            // Execute test Coverage
            sh "npx nyc --reporter=lcov npm run test"

            // Generate inform
            sh "npx nyc report --reporter=html"
        }

        utils.info "CodeCoverageStage", "Finish Node.js Strategy"
    }
}
