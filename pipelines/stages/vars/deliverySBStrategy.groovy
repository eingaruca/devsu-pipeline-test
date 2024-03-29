def call() {
    withFolderProperties{
        utils.info "deliverySBStrategy", "Springboot Strategy"
        sh "ls -l"
    }
}