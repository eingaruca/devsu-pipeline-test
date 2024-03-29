import org.emic.devsu.*

def call (body) {
    withFolderProperties {
        utils.info "mainInfrastructure", "Starting Pipeline"

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
        
        // Variables
        def cloudTypeVar  = config.cloudType
        cloudTypeVar      = utils.formatText(cloudTypeVar)

        if ( cloudTypeVar != null ) {

            node {
                stage ( "Checkout Stage" ) { 
                    CheckoutStage.init(this)    
                }
                stage ( "Terraform init" ) {
                    TerraformInitStage.init(this)
                }
            }
        }
  
    }
}