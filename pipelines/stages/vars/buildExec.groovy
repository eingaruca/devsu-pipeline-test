def call() {
    withFolderProperties {
        log.info("BuildExec", "Building")
        def image = "maven:3.8.3-openjdk-17"
        log.info("BuildStage", "Workspace: ${env.WORKSPACE}")
     
        def maven = docker.image(image)

        maven.inside {
            sh "java -version"
            sh "mvn -f ${env.WORKSPACE}/pom.xml clean -U -B package -Dskip.unit.tests=true -Dmaven.test.skip=true -Dpmd.skip=true"
            
        }
        stash name: 'build' //, includes: 'pom.xml,**/pom.xml,**/src/,src/'
        log.info "BuildStage", "Fin Build"
    }
}