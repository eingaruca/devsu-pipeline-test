# Devsu - DevOps - Prueba Técnica

## Overview
Este es un proyecto realizado en el marco del proceso de Selección de Devsu.

- Autor: Eldo M. Ingaruca Cruzado

El proyecto quiere representar una serie de automatismos para desplegar infraestructura en diferentes proveedores Cloud, configuración de dichos recursos y un ciclo de CI/CD de aplicaciones de Java, Node.js y Python.

La presente documentación hará énfasis, primero, en el despliegue y configuración de la infraestructura y luego abarcaremos el ciclo completo de CI/CD.


## 1. Infraestrctura

### 1.1 Introducción
Se ha querido dar un enfoque total. Crear una librería escrita en Groovy para Jenkins que sea escalable. Utilizando una estructura similar para diferentes tipos de proyectos, clouds y recursos.

Link: https://github.com/eingaruca/devsu-pipeline-test/tree/main/pipelines/infrastructure/library

Tecnologías utilizadas:
  - Jenkins pipelines
  - Groovy
  - Terraform
  - Ansible

### 1.2 Pipeline
![alt text](<images/ArchitectureDiagram-Infrastructure Cycle.webp>)

Tal como se puede ver en el gráfico, se ha creado la librería Groovy que tendrá que utilizar cada Jenkinsfile. Esta librería aporta 5 etapas al pipeline.
- **Checkout Stage**: Obligatorio y necesario para el workspace.
- **Terraform Init Stage**: Etapa común a cualquier inicialización de un proyecto Terraform.
- **Terraform Plan Stage**: Terraform plan. Recibirá diferentes parámetros del Jenkinsfile que lo llevarán a las diferentes estrategias:
  - **GCP Strategy**: Recibirá el tipo de recurso, proyecto, nombre de recurso y se ampliará en el futuro a ciertos parámetros más personalizables.
  - **Azure Strategy**: No implementado, mejora futura.
  - **AWS Strategy**: No implementado, mejora futura.
- **Terraform Apply Stage**: Terraform apply. Igual que la etapa anterior, recibirá parámetros que condicionarán su comportamiento o estrategia.
  - **GCP Strategy**: Recibirá el tipo de recurso, proyecto, nombre de recurso y se ampliará en el futuro a ciertos parámetros más personalizables.
  - **Azure Strategy**: No implementado, mejora futura.
  - **AWS Strategy**: No implementado, mejora futura.
- **Post Stage**: Borrar el workspace

### 1.3 Estructura de clases:

![alt text](images/infraClasses.png)





sd
- as

![alt text](images/mainInfrastructure.png)
Consta de tres etapas muy marcadas.

- Despliegue infrastructura
  - IaC
    - Google cloud
      - 

![alt text](<images/ArchitectureDiagram-DevOps Cycle.webp>)

#