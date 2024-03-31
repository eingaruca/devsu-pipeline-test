def call() {
    withFolderProperties{
        utils.info "CodeCoverageStage", "Starging Springboot Strategy"
         // Define Docker image
        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        // // Execute commands inside Docker container
        
        maven.inside {
            // sh "java -version"
            unstash name : 'build'
            sh "mvn clean test jacoco:report"
            jacoco (
                execPattern: '**/build/jacoco/*.exec',
                classPattern: '**/build/classes/java/main',
                sourcePattern: '**/src/main'
            )
        }


        
        utils.info "CodeCoverageStage", "Finish Springboot Strategy"
    }
}