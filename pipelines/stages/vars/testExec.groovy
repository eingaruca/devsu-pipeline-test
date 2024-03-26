def call(){

    withFolderProperties {
        log.info "TestStage", "Testing project"

        unstash name: 'build'

        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        maven.inside {
            sh "java -version"

            springBootTests()
            sh "mvn -f ${env.WORKSPACE}/pom.xml verify -Dskip.acceptance.tests=false -Dskip.integration.tests=true -Dskip.unit.tests=true -Dpmd.skip=true -Dcheckstyle.skip=true"
            
        }

    }

    def springBootTests (){
        echo "HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    }

    def acceptanceTest () {

    }

}