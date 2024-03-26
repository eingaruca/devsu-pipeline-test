// Springboot Tests Strategy
def springBootTests () {
    parallel(
        "Unit Tests": { sbUnitTest() },
        "Acceptance Tests": { sbAcceptanceTest() },
        "Integration Tests": { sbIntegrationTest() },
        failFast: true
    )
}

def sbUnitTest () {
    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml test -Dskip.unit.tests=false -Dskip.integration.tests=true -Dskip.acceptance.tests=true"
}

def sbAcceptanceTest () {
    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml verify -Dskip.acceptance.tests=false -Dskip.integration.tests=true -Dskip.unit.tests=true -Dpmd.skip=true -Dcheckstyle.skip=true"
}

def sbIntegrationTest () {
    unstash name: 'build'
    sh "mvn -f ${env.WORKSPACE}/pom.xml verify -Dskip.integration.tests=false -Dskip.acceptance.tests=true -Dskip.unit.tests=true"
}

//NodeJs Tests

// Python tests