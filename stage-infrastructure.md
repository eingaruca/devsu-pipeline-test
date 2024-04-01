# Registro de ejecución de pipeline
Registro de una muestra de cómo se ejecuta un pipeline para desplegar un recurso en Google Cloud

## 1. Previo a ejecución
![Alt text](images/cloud-mainpipeline.png)
## 2. Ejecución

La ejecución del pipeline en Jenkins se ve de la siguiente manera:

![Alt text](images/cloud-exec.png)


En el output del pipeline se puede apreciar que ha desplegado sobre Google Cloud, terminando el Apply del Terraform:

![Alt text](images/cloud-output.png)

Para ver el log de esta ejecución:
[LOG](cloud-pipeline-log.txt)
