package org.emic.devsu

class TerraformPlanStage {

    static void init (script, dirResources, instanceNameVar, projectVar) {
        script.utils.info "TerraformPlanStage", "Starting Plan"

        planStrategy(script, dirResources, instanceNameVar, projectVar)
        
        script.utils.info "TerraformPlanStage", "Finish Plan"
    }

    private static void planStrategy (script, dirResources, instanceNameVar, projectVar) {
        // script.planStrategy(dirResources, instanceNameVar, projectVar)
    }

}