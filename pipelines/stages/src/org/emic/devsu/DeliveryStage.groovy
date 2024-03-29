package org.emic.devsu

class DeliveryStage {

    static void init (script, projectTypeVar){

        script.utils.info "DeliveryStage", "Starting Delivery Stage"

        switch (projectTypeVar) {
            case 'springboot':
                deliverySBStrategy(script)
                break
            case 'nodejs':
                deliveryNodejsStrategy(script)
                break
            case 'django':
                deliveryDjangoStrategy(script)
                break
            default:
                script.utils.error  "DeliveryStage", "No existe tipo Proyecto, elija springboot, nodejs o django"
        }

        script.utils.info "DeliveryStage", "Finish Delivery Stage"
    }

    private static void deliverySBStrategy(script) {
        script.deliverySBStrategy()
    }

    private static void deliveryNodejsStrategy(script) {
        script.deliveryNodejsStrategy() // Change class different to SpringBoot Strategy in the future
    }

    private static void deliveryDjangoStrategy(script) {
        script.deliveryNodejsStrategy() // Change class different to SpringBoot Strategy in the future
    }
}