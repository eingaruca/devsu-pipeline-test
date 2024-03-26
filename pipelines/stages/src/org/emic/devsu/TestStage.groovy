package org.emic.devsu

class TestStage {

    static void init (script) {
        testExec(script)
    }

    private static void BDDTest (script){
        script.testExec()
    }
}