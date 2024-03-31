def call() {
    withFolderProperties{
        utils.info "CodeCoverageStage", "Starging Springboot Strategy"
         // Define Docker image
        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        // Execute commands inside Docker container
        unstash name : 'build'
        maven.inside {
            sh "java -version"
            sh "mvn clean test jacoco:report"
        }
        utils.info "CodeCoverageStage", "Finish Springboot Strategy"
    }
}