// Springboot Tests Strategy
// def springBootTests (flags) {

//     if ( flags[0] ) sbUnitTest()
//     if ( flags[1] ) sbAcceptanceTest()
//     if ( flags[2] ) sbIntegrationTest()
// }

def call (flags) {
    withFolderProperties {
        unstash name: 'build'
        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        maven.inside {
            sh "java -version"
            if ( flags[0] ) sbUnitTest()
            if ( flags[1] ) sbAcceptanceTest()
            if ( flags[2] ) sbIntegrationTest()
        }
        
    }
}

def sbUnitTest () {
    utils.info "TestStage", "Starting UNIT Test"

    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml test -Dskip.unit.tests=false -Dskip.integration.tests=true -Dskip.acceptance.tests=true"

    utils.info "TestStage", "Finish UNIT Test"
}

def sbAcceptanceTest () {
    utils.info "TestStage", "Starting ACCEPTANCE Test"

    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml verify -Dskip.acceptance.tests=false -Dskip.integration.tests=true -Dskip.unit.tests=true -Dpmd.skip=true -Dcheckstyle.skip=true"

    utils.info "TestStage", "Finish ACCEPTANCE Test"
}

def sbIntegrationTest () {
    utils.info "TestStage", "Starting INTEGRATION test"
    
    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml verify -Dskip.integration.tests=false -Dskip.acceptance.tests=true -Dskip.unit.tests=true"

    utils.info "TestStage", "Finish INTEGRATION test"
}