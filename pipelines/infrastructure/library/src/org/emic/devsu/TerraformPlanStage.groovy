package org.emic.devsu

class TerraformInitStage {

    static void init (script) {
        script.utils.info "TerraformPlanStage", "Starting Plan"

        planStrategy(script)
        
        script.utils.info "TerraformPlanStage", "Finish Plan"
    }

    private static void planStrategy (script) {
        script.planStrategy()
    }

}