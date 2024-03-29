def call () {
    withFolderProperties {
        sh "terraform --version"
    }
}