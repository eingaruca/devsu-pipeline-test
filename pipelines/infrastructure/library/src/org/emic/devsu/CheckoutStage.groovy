package org.emic.devsu

class CheckoutStage {

    static void init (script) {
        script.utils.info "CheckoutStage", "Starting checkout"

        checkoutStrategy(script)
        checkoutInfo(script)
        
        script.utils.info "CheckoutStage", "Finish checkout"
    }

    private static void checkoutStrategy (script) {
        script.checkoutStrategy()
    }

    private static void checkoutInfo(script){
        script.checkoutInfo()
    }
}