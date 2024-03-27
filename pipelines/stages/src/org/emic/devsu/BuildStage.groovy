package org.emic.devsu

class BuildStage {

    static void init (script, projectTypeVar) {
        
        script.utils.info "BuildStage", "Starting BuildStage"

        switch (projectTypeVar) {
            case 'springboot':
                buildSBStrategy(script)
                break
            case 'nodejs':
                buildNodejsStrategy(script)
                break
            case 'django':
                buildDjangoStrategy(script)
                break
            default:
                script.utils.error  "BuildStage", "No existe tipo Proyecto, elija springboot, nodejs o django"
        }

        script.utils.info "BuildStage", "Finish BuildStage"
    }

    private static void buildSBStrategy(script){
        script.buildSBStrategy()
    }

    private static void buildNodejsStrategy(script){
        script.buildNodejsStrategy()
    }

    private static void buildDjangoStrategy(script){
        script.buildDjangoStrategy()
    }


}