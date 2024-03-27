package org.emic.devsu

class CodeAnalysisStage {

    static void init (script, projectTypeVar){

        script.utils.info "CodeAnalysisStage", "Starting Static Code Analysis"
        // script.codeAnalysisStrategy("springboot")

        switch (projectTypeVar) {
            case 'springboot':
                codeAnalysisSBStrategy(script)
                break
            case 'nodejs':
                codeAnalysisNodejsStrategy(script)
                break
            case 'django':
                codeAnalysisDjangoStrategy(script)
                break
            default:
                script.utils.error  "CodeAnalysisStage", "No existe tipo Proyecto, elija springboot, nodejs o django"
        }

        script.utils.info "CodeAnalysisStage", "Finish Static Code Analysis"
    }

    private static void codeAnalysisSBStrategy(script) {
        script.codeAnalysisSBStrategy()
    }

    private static void codeAnalysisNodejsStrategy(script) {
        script.codeAnalysisNodejsStrategy()
    }

    private static void codeAnalysisDjangoStrategy(script) {
        script.codeAnalysisDjangoStrategy()
    }
}