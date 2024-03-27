package org.emic.devsu

class TestStage {

    static void init (script, projectTypeVar, testVar) {

        script.utils.info "TestStage", "Starting TestStage"

        switch (projectTypeVar) {
            case 'springboot':
                testSBStrategy(script, testVar)
                break
            case 'nodejs':
                testNodejsStrategy(script, testVar)
                break
            case 'django':
                testDjangoStrategy(script, testVar)
                break
            default:
                script.log.error "TestStage", "Doesn't match projectType, choose springboot, nodejs or django"
        }
        script.utils.info "TestStage", "Finish TestStage"
    }

    private static void testSBStrategy(script, testVar){
        script.echo "${testVar.getClass().getName()}"
        script.testSBStrategy(testVar)
    }

    private static void testNodejsStrategy(script, testVar){
        script.testNodejsStrategy(testVar)
    }

    private static void testDjangoStrategy(script, testVar){
        script.testDjangoStrategy(testVar)
    }

}