package org.emic.devsu

class CheckoutStage {

    static void init (script) {
        script.echo "[INFO] Estoy en checkoutStage"
        checkoutExec(script)
        checkoutInfo(script)
    }

    private static void checkoutInfo(script){
        script.checkoutInfo()
    }

    private static void checkoutExec (script) {
        script.checkoutExec()
    }
}