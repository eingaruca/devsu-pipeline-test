package org.emic.devsu

class TerraformInitStage {

    static void init (script) {
        script.utils.info "TerraformInitStage", "Starting init"

        checkoutStrategy(script)
        checkoutInfo(script)
        
        script.utils.info "TerraformInitStage", "Finish init"
    }

    private static void checkoutStrategy (script) {
        script.checkoutStrategy()
    }

}