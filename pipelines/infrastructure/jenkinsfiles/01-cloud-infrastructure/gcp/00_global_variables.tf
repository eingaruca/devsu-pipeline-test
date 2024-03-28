# Provider
# variable "credentials"          { default = "${file("../keys/iaas-ss-databases-98694fa6cc45.json")}" }
variable "credentials"          { default = "credentials/devsu-project.json" }
variable "project"              { default = "devsu-project" }
# Resources
variable "region"               { default = "europe-west1" }
variable "zone"                 { default = "europe-west1-b" }

