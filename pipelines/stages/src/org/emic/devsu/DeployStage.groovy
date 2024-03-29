package org.emic.devsu

class DeployStage {

    static void init (script, projectTypeVar){

        script.utils.info "DeployStage", "Starting Deployment Stage"

        switch (projectTypeVar) {
            case 'springboot':
                deploySBStrategy(script)
                break
            case 'nodejs':
                deployNodejsStrategy(script)
                break
            case 'django':
                deployDjangoStrategy(script)
                break
            default:
                script.utils.error  "DeployStage", "No existe tipo Proyecto, elija springboot, nodejs o django"
        }

        script.utils.info "DeployStage", "Finish Deployment Stage"
    }

    private static void deploySBStrategy(script) {
        script.deploySBStrategy() // Change class different to SpringBoot Strategy in the future
    }

    private static void deployNodejsStrategy(script) {
        script.deploySBStrategy() // Change class different to SpringBoot Strategy in the future
    }

    private static void deployDjangoStrategy(script) {
        script.deploySBStrategy() // Change class different to SpringBoot Strategy in the future
    }
}