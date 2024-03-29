package org.emic.devsu

class TerraformApplyStage {

    static void init (script, dirResources, instanceNameVar, projectVar) {
        script.utils.info "TerraformApplyStage", "Starting Apply"

        applyStrategy(script, dirResources, instanceNameVar, projectVar)
        
        script.utils.info "TerraformApplyStage", "Finish Apply"
    }

    private static void applyStrategy (script, dirResources, instanceNameVar, projectVar) {
        script.applyStrategy(dirResources, instanceNameVar, projectVar)
    }

}