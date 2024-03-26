// vars/log.groovy

def info(className, message) {
    echo "[INFO] [${className}] ${message}"
}

def warning(className, message) {
    echo "[WARNING] [${className}] ${message}"
}

def error(className, message) {
    echo "[ERROR] [${className}] ${message}"
}