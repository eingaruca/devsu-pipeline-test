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

            if ( testVar != null  ){
                stage ( "Test Stage" ) {
                    TestStage.init(this, projectTypeVar, testVar)
                }
            }
            

            stage ( "Static Code Analysis Stage" ){
                echo "Analysis"
                // CodeAnalysisStage.init(this)
            }

        }
    }
}