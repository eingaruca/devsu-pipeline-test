// Springboot Tests Strategy
def springBootTests () {
    sbUnitTest()
    sbAcceptanceTest()
    sbIntegrationTest()
}

def sbUnitTest () {
    log.info "TestStage", "UNIT TEST"
    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml test -Dskip.unit.tests=false -Dskip.integration.tests=true -Dskip.acceptance.tests=true"
}

def sbAcceptanceTest () {
    log.info "TestStage", "ACCEPTANCE TEST"
    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml verify -Dskip.acceptance.tests=false -Dskip.integration.tests=true -Dskip.unit.tests=true -Dpmd.skip=true -Dcheckstyle.skip=true"
}

def sbIntegrationTest () {
    log.info "TestStage", "INTEGRATION TEST"
    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml verify -Dskip.integration.tests=false -Dskip.acceptance.tests=true -Dskip.unit.tests=true"
}

//NodeJs Tests

def nodejsTests () {

}

// Python tests

def pythonTests () {

}