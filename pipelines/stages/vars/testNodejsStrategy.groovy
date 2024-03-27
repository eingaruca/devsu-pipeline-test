def call (flags) {
    withFolderProperties {
        unstash name: 'build'
        def image = "node:20-alpine3.18"
        def node = docker.image(image)
        node.inside {
            sh "node --version"
            sh "npm --version"
            if ( flags[0] ) nodejsUnitTest()
            if ( flags[1] ) nodejsAcceptanceTest()
            if ( flags[2] ) nodejsIntegrationTest()
        }
        
    }
}

def nodejsUnitTest () {
    utils.info "TestStage", "Starting Nodejs UNIT Test"

    unstash name: 'build'
    sh "npm run test" 

    utils.info "TestStage", "Finish Nodejs UNIT Test"
}

def nodejsAcceptanceTest () {
    utils.warning "TestStage", "Starting Nodejs ACCEPTANCE Test"

    // unstash name: 'build'
    utils.warning "TestStage", " *** Acceptance Test - EMPTY function, no code ***"

    utils.warning "TestStage", "Finish Nodejs ACCEPTANCE Test"
}

def nodejsIntegrationTest () {
    utils.warning "TestStage", "Starting INTEGRATION test"
    
    // unstash name: 'build'
    utils.warning "TestStage", "*** Integration Test - EMPTY function, no code ***"

    utils.warning "TestStage", "Finish Nodejs INTEGRATION test"
}