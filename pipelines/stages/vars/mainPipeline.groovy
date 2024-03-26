import org.emic.devsu.*

def call (body) {
    withFolderProperties {
        echo "[INFO] Test mainPipeline.groovy"
        log.info "mainPipeline", "Starting Pipeline"

        node {
            stage ( "Checkout Stage" ) {
                CheckoutStage.init(this)
            }
            
            stage ( "Build Stage" ) {
                BuildStage.init(this)
            }

            stage ( "Test Stage" ) {
                TestStage.init(this)
            }

        }
    }
}