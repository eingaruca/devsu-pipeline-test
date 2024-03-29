def call (dirResources) {
    withFolderProperties {
        dir (dirResources) {
            // sh "ls -l"
            sh "terraform init"
        }
    }
}