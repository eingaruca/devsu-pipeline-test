# Basics
variable "instance_name"        {}
variable "zone"                 {}
variable "region"               {}
variable "machine_type"         {}
variable "image"                {}
# Networking
variable "subnetwork"           {}
variable "ip_addresses"         {
    type = list(object({
      ip_address = string
      subnetwork = string
    }))
  }

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