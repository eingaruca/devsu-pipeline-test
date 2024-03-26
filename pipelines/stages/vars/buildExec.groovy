def call() {
    withFolderProperties {
        log.info("BuildExec", "Building")
        def image = "maven:latest"
        log.info("BuildStage", "Workspace: ${env.WORKSPACE}")
     
        def maven = docker.image(image)

        maven.inside {
            sh "mvn -f ${env.WORKSPACE}/frontend_testing/bootstrap_menu/testingsb/pom.xml clean -U -B package -Dskip.unit.tests=true -Dmaven.test.skip=true -Dpmd.skip=true"
            log.info "BuildStage", "Fin Build mvn"
        }
    }
}