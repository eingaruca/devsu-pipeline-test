import org.emic.devsu.*

def call (body) {
    withFolderProperties {
        echo "[INFO] Test mainPipeline.groovy"


        node {
            stage ( "Checkout Stage" ) {
                CheckoutStage.init(this)
            }
        }
    }
}