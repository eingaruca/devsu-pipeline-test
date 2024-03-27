def call () {
    withFolderProperties{
        utils.info "CheckoutStage", "Starting CheckoutStrategy scm"

        checkout scm
        
        utils.info "CheckoutStage", "Finish CheckoutStrategy scm"
    }
}