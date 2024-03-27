def call(flags) {
    withFolderProperties {
        // Asumiendo que ya has construido tu proyecto Django
        unstash name: 'build'
        
        // def image = "python:alpine3.19"
        def image = "python:slim-bullseye"
        def python = docker.image(image)
        
        python.inside {
            sh "python --version"
            if (flags[0]) djangoUnitTest()
            if (flags[1]) djangoAcceptanceTest()
            if (flags[2]) djangoIntegrationTest()

            // Agrega aquí cualquier otra prueba que necesites ejecutar
        }
    }
}

def djangoUnitTest() {
    utils.info "TestStage", "Starting Django Unit Test"

    unstash name: 'build'
    sh "python manage.py test"

    utils.info "TestStage", "Finish Django Unit Test"
}

def djangoAcceptanceTest() {
    utils.info "TestStage", "Starting Django Acceptance Test"

    // unstash name: 'build'
    utils.warning "TestStage", " *** Acceptance Test - EMPTY function, no code ***"

    utils.info "TestStage", "Finish Django Acceptance Test"
}

def djangoIntegrationTest() {
    utils.info "TestStage", "Starting Django Integration Test"

    unstash name: 'build'
    sh "python manage.py test --tag integration"

    utils.info "TestStage", "Finish Django Integration Test"
}