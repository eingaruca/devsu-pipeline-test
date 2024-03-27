def call() {
    withFolderProperties {
        utils.info "BuildStage", "Starting SpringBoot Strategy"
        utils.info "BuildStage", "Workspace: ${env.WORKSPACE}"

        // Define Docker image
        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        // Execute commands inside Docker container
        maven.inside {
            sh "java -version"
            sh "mvn -f ${env.WORKSPACE}/pom.xml clean -U -B package -Dskip.unit.tests=true -Dmaven.test.skip=true -Dpmd.skip=true"
            
        }
        // Make stash to use in other stages
        stash name: 'build' //, includes: 'pom.xml,**/pom.xml,**/src/,src/'
        utils.info "BuildStage", "Finish SpringBoot Strategy"
    }
}