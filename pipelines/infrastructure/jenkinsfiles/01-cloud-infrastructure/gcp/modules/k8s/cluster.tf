resource "google_container_cluster" "cluster" {
    #Cluster Basics
    name     = var.cluster_name
    location = var.location
    node_locations = var.node_locations
    release_channel {
      channel = var.release_channel
    }
    min_master_version = var.gke_version
    remove_default_node_pool = true
    initial_node_count       = 1
    private_cluster_config{
        enable_private_nodes = true
        enable_private_endpoint = true
        master_ipv4_cidr_block = var.cluster_range
        master_global_access_config{
            enabled = true
        }
    }

    vertical_pod_autoscaling{
        enabled = false
    }
    cluster_autoscaling {
      enabled = false
    }
    addons_config {
        http_load_balancing{
            disabled = false
        }
    }

    default_snat_status {
      disabled = false
    }

    ## Network = 
    network = var.network
    subnetwork = var.subnetwork
    networking_mode = "VPC_NATIVE"
    ip_allocation_policy {
        cluster_secondary_range_name    = "alias1"
        services_secondary_range_name   = "alias2"
    }

    default_max_pods_per_node = 30
    enable_intranode_visibility = true
    enable_l4_ilb_subsetting = false
    master_authorized_networks_config {
      cidr_blocks {
        cidr_block = var.master_range_allow
      }
    }

    network_policy {
      enabled = true
      provider = "CALICO"

    }
    # dns_config {
    #   cluster_dns = "Kube-dns"
    # }
    resource_labels           = var.resource_labels
}