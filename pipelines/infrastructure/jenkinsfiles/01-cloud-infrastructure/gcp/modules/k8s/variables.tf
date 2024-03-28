#################
## Cluster GKE ##
#################
variable "cluster_name"                 {}
variable "release_channel"              { default= "STABLE" }
variable "gke_version"                  { }

#Cluster Cluster
variable "location"                     {}
variable "cluster_range"                {}
variable "resource_labels"              {}

# Nodes
variable "node_locations"               {}
variable "machine_type"                 { default = "n1-standard-1" }
variable "node_count_pool1"             {}
variable "node1_tags"                   { default = "No Tags" }
variable "node1_labels"                 {}
# Si node1_enable_autoscaling = true, usar nodex_min_node_count
variable "node1_enable_autoscaling"     { default = false }
variable "node1_min_node_count"         { default = 1 }
variable "node1_max_node_count"         { default = 2 }

############################
## Variables VCN - Subnet ##
############################
variable "network"                      {}
variable "subnetwork"                   {}
variable "master_range_allow"           {}