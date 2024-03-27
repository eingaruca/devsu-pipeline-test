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