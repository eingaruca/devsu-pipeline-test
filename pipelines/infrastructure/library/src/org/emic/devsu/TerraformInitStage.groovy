package org.emic.devsu

class TerraformInitStage {

    static void init (script, dirResources) {
        script.utils.info "TerraformInitStage", "Starting init"

        initStrategy(script, dirResources)
        
        script.utils.info "TerraformInitStage", "Finish init"
    }

    private static void initStrategy (script, dirResources) {
        script.initStrategy(dirResources)
    }

}