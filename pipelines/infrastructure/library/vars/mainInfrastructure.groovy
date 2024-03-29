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
        def resourceTypeVar  = config.resourceType
        resourceTypeVar      = utils.formatText(resourceTypeVar)

        def dirResources  = "pipelines/infrastructure/library/terraform-ansible/resources/"

        dirResources = dirResources.concat(resourceTypeVar)

        // Local variables
        if (resourceType == 'instance') {
            def instanceNameVar = config.instanceName
        }

        def projectVar = "devsu-project"
        if ( config.project != null ){
            projectVar = config.project
        }


        if ( cloudTypeVar != null ) {

            node {
                stage ( "Checkout Stage" ) { 
                    // dir(dirResources){
                    CheckoutStage.init(this)    
                    // }
                }
                stage ( "Terraform Init Stage" ) {
                    // dir(dirResources){
                    TerraformInitStage.init(this, dirResources)
                    // }
                }
                stage ( "Terraform Plan Stage" ) {
                    // dir(dirResources){
                    echo "Terraform plan stage"
                    TerraformPlanStage.init(this, dirResources, instanceNameVar, projectVar)
                    // }
                }
            }
        }
  
    }
}