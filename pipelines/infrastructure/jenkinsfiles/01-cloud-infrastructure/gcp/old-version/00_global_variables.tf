# Provider
# variable "credentials"          { default = "${file("../keys/xxx.json")}" }
variable "credentials"          { default = "credentials/devsu-project.json" }
variable "project"              { default = "devsu-project" }
# Resources
variable "region"               { default = "europe-west1" }
variable "zone"                 { default = "europe-west1-b" }

