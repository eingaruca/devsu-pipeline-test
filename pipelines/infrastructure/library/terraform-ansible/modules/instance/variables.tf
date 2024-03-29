# Basics
variable "instance_name"        {}
variable "zone"                 {}
variable "region"               {}
variable "machine_type"         { default = "n1-standard-1" }
variable "image"                {}
# Networking
variable "network"              { default = "default" }
variable "subnetwork"           { default = "default" }
# variable "ip_addresses"         {
#     type = list(object({
#       ip_address = string
#       subnetwork = string
#     }))
#   }

# Storage
variable "initial_size"         {}
variable "disks"                {
  type = list(object({
    source      = string
    device_name = string
  }))
}

# Metadata
variable "labels"               {
  type = map(string)
}
variable "network_tags"         { default = [null] }
variable "service_account"      {}
variable "resource_policies"    { default = [null] }


variable "user"         { default = "eldomanu" }
variable "publickey"    { default = "./gcp_key.pub" }
variable "privatekey"   { default = "./gcp_key" }
