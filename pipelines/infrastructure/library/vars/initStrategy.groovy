def call () {
    withFolderProperties {
        sh "ls -l"
        sh "terraform init"
    }
}