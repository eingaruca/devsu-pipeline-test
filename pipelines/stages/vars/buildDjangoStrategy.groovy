def call() {
    withFolderProperties {
        utils.info "BuildStage", "Starting Django Strategy"

        // Define Docker image
        def image = "python:alpine3.19"
        def python = docker.image(image)

        // Execute commands inside Docker container
        python.inside {
            sh "pip install -r requirements.txt"
            sh "python manage.py migrate"

            // sh "python manage.py collectstatic --no-input"
        }

        // Make stash to use in other stages
        stash name: 'build' , includes: '**/*'

        utils.info "BuildStage", "Finish Django Strategy"
    }
}
