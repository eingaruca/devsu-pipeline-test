#################
## Cluster GKE ##
#################
variable "cluster_name"                 {}
variable "release_channel"              { default= "STABLE" }
variable "gke_version"                  { }

#Cluster Cluster
variable "location"                     {}
variable "cluster_range"                { default = "10.132.0.0/28" }
variable "resource_labels"              { default = {"name" = "No-labels"}}

# Nodes
variable "nodepool_name"                { default = "pool-1" }
variable "node_locations"               {}
variable "machine_type"                 { default = "n1-standard-1" }
variable "node_count_pool1"             { default = 1 }
variable "node1_tags"                   { default = ["notags"] }
variable "node1_labels"                 { default = { "name" = "notags" } }
# Si node1_enable_autoscaling = true, usar nodex_min_node_count
# variable "node1_enable_autoscaling"     { default = false }
# variable "node1_min_node_count"         { default = 1 }
# variable "node1_max_node_count"         { default = 2 }

############################
## Variables VCN - Subnet ##
############################
variable "network"                      {}
variable "subnetwork"                   {}
# Allow external networks access to Kubernetes Cluster Master
variable "master_range_allow"           { default = "10.132.0.0/20" }