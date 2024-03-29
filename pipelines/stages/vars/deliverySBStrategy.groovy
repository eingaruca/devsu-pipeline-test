def call() {
    withFolderProperties{
        utils.info "deliverySBStrategy", "Springboot Strategy"
        sh "docker build -t demosb ."
    }
}