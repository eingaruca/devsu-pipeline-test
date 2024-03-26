def call () {
    withFolderProperties{
        log.info("CheckoutStage", "checkout scm")
        checkout scm
    }
}