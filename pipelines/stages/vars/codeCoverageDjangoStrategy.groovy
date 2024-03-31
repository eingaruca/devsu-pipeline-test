def call() {
    withFolderProperties{
        utils.info "CodeCoverageStage", "Django Strategy"
        // Define Docker image
        def image = "python:alpine3.19"
        def python = docker.image(image)

        // Execute commands inside Docker container
        python.inside {
            unstash name: 'build'
            // sh "pip install -r requirements.txt"
            sh "pip install coverage"
            sh "python manage.py migrate"

            // Ejecutar pruebas con cobertura
            sh "coverage run manage.py test"
            
            // Generar informe de cobertura
            sh "coverage report"
            sh "coverage html"
        }

        utils.info "CodeCoverageStage", "Finish Django Strategy"
    }
}
