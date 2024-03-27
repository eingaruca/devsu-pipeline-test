package org.emic.devsu

class CodeCoverageStage {

    static void init (script, projectTypeVar){

        script.utils.info "CodeCoverageStage", "Starting Static Code Coverage"

        switch (projectTypeVar) {
            case 'springboot':
                codeCoverageSBStrategy(script)
                break
            case 'nodejs':
                codeCoverageNodejsStrategy(script)
                break
            case 'django':
                codeCoverageDjangoStrategy(script)
                break
            default:
                script.utils.error  "CodeCoverageStage", "No existe tipo Proyecto, elija springboot, nodejs o django"
        }

        script.utils.info "CodeCoverageStage", "Finish Static Code Analysis"
    }

    private static void codeCoverageSBStrategy(script) {
        script.codeCoverageSBStrategy()
    }

    private static void codeCoverageNodejsStrategy(script) {
        script.codeCoverageNodejsStrategy()
    }

    private static void codeCoverageDjangoStrategy(script) {
        script.codeCoverageDjangoStrategy()
    }
}