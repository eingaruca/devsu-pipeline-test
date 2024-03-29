// vars/log.groovy

def info(className, message) {
    echo "[INFO] [${className}] ${message}"
}

def warning(className, message) {
    echo "[WARNING] [${className}] ${message}"
}

def error(className, message) {
    error "[ERROR] [${className}] ${message}"
}

def formatText(text) {
    if (text != null) {
        text = text.replaceAll("\\s", "").toLowerCase()
    } else {
        error "[ERROR] Indique valor de projectType en mainPipeline"
    }
    return text
}

def region (){
    return "europe-west1"
}

def zone (){
    return "europe-west1-b"
}

def credentials (){
    return "../../credentials/devsu-project.json"
}