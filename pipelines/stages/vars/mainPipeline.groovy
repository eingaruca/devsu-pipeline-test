import org.emic.devsu.*

def call (body) {
    withFolderProperties {
        utils.info "mainPipeline", "Starting Pipeline"

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
        
        // Variables
        // def checkoutVar = config.checkout ==> Mandatory
        def projectTypeVar  = config.projectType
        def buildVar        = config.build
        def testVar         = config.test
        def codeAnVar       = config.codeAnalysis

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
                    utils.info "mainPipeline", "TestSTAGE"
                }
            }
            // Optional Static Code Analysis Stage
            if ( codeAnVar != null || codeAnVar ){
                //Code Coverage
                //https://medium.com/@Anu_Rag/indepth-ci-cd-of-a-maven-project-a59961e448d7
                stage ( "Static Code Analysis Stage" ){
                    CodeAnalysisStage.init(this, projectTypeVar)
                }
            }
            stage ( "Docker Pull Stage" ) {
                DeliveryStage.init(this, projectTypeVar)
            }

        }
    }
}