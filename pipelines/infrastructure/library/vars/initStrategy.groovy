def call () {
    withFolderProperties {
        
        def image = "hashicorp/terraform:1.8.0-rc1"
        def terraform = docker.image(image)
        // Execute commands inside Docker container
        terraform.inside {
            sh "terraform --version"
        }
    }
}