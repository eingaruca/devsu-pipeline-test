package org.emic.devsu

class TestStage {

    static void init (script) {
        BDDTest(script)
    }

    private static void BDDTest (script){
        script.testExec()
    }
}