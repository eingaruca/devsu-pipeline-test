package org.emic.devsu

class CodeAnalysisStage {

    static void init (script){
        // code .trim() and lowercase else if default error if not in options
        script.log.info "CodeAnalysis", "Starting"
        script.codeAnalysisStrategy("springboot")
    }
}