package org.emic.devsu

class TerraformInitStage {

    static void init (script) {
        script.utils.info "TerraformInitStage", "Starting init"

        initStrategy(script)
        
        script.utils.info "TerraformInitStage", "Finish init"
    }

    private static void initStrategy (script) {
        script.initStrategy()
    }

}