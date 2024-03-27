def call(flags) {
    withFolderProperties {
        // Asumiendo que ya has construido tu proyecto Django
        unstash name: 'build'
        
        def image = "python:alpine3.19"
        // def image = "python:slim-bullseye"
        def python = docker.image(image)
        
        python.inside {
            sh "python --version"
            sh "pip install -r requirements.txt"
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
    sh "echo ${pwd}"
    sh "echo whoami"
    echo "ls -l"
    sh "python manage.py test -v 2"

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
    sh "python manage.py test --tag integration -v 2"

    utils.info "TestStage", "Finish Django Integration Test"
}