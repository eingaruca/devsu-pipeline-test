import org.emic.devsu.*

def call (body) {
    withFolderProperties {
        utils.info "mainPipeline", "Starting Pipeline"

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
        
        // Variables
        def projectTypeVar  = config.projectType
        def buildVar        = config.build
        def testVar         = config.test
        def codeAnVar       = config.codeAnalysis
        def codeCoverageVar = config.codeCoverage
        def deliveryVar     = config.delivery
        def deployVar       = config.deploy

        projectTypeVar      = utils.formatText(projectTypeVar)
        
        node {
            stage ( "Checkout Stage" ) { // Mandatory stage
                CheckoutStage.init(this)
            }            
            stage ( "Build Stage" ) { // Mandatory stage
                BuildStage.init(this, projectTypeVar)
            }

            // Optional Test Stage
            if ( testVar != null  ){
                stage ( "Test Stage" ) {
                    // TestStage.init(this, projectTypeVar, testVar)
                    utils.info "mainPipeline", "Test STAGE"
                }
            }

            // Optional Static Code Analysis Stage
            if ( codeAnVar != null || codeAnVar ){
                stage ( "Static Code Analysis Stage" ){
                    utils.info "mainPipeline", " Code Analysis STAGE"
                    // CodeAnalysisStage.init(this, projectTypeVar)
                }
            }

            // Optional Code Coverage Stage
            if ( codeCoverageVar ){
                stage ( "Code Coverage Stage" ){
                    utils.info "mainPipeline", " Code Coverage STAGE"
                    // CodeCoverageStage.init(this, projectTypeVar)
                }
            }

            // Optional Delivery Stage
            if ( deliveryVar ){
                stage ( "Delivery (Docker) Stage" ) {
                    DeliveryStage.init(this, projectTypeVar)
                }
            }

            // Optional Deploy Stage
            if ( deployVar ){
                stage ( "Deploy (GKE) Stage" ) {
                    DeployStage.init(this, projectTypeVar)
                }
            }
        }
    }
}