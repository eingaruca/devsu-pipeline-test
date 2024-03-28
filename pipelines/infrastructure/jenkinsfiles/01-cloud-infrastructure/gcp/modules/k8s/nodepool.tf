resource "google_container_node_pool" "pool-1" {
    #Basic Configuration
    name       = var.nodepool_name
    cluster    = google_container_cluster.cluster.id
    node_count = var.node_count_pool1
    node_locations = var.node_locations

    # ## Autoscaling = On (1-3 nodes per zone)
    # dynamic "autoscaling" {
    # # If node1_enable_autoscaling, use autoscaling parameters (Min-Max)
    # for_each = var.node1_enable_autoscaling ? [1] : []
    #     content {
    #     max_node_count = var.node1_max_node_count
    #     min_node_count = var.node1_min_node_count
    #     }
    # }

    node_config {
        image_type      = "COS_CONTAINERD"
        machine_type    = var.machine_type
        disk_type       = "pd-ssd"
        disk_size_gb    = "10"
        
        # shielded_instance_config {
        #     enable_integrity_monitoring = true
        #     # enable_secure_boot          = true
        # }
        # service_account = google_service_account.default.email
        oauth_scopes    = [
            # "https://www.googleapis.com/auth/devstorage.full_control",
            "https://www.googleapis.com/auth/devstorage.read_only",
            "https://www.googleapis.com/auth/logging.write",
            "https://www.googleapis.com/auth/servicecontrol",
            "https://www.googleapis.com/auth/service.management.readonly",
            "https://www.googleapis.com/auth/monitoring",
            "https://www.googleapis.com/auth/trace.append"
        ]

        labels  = var.node1_labels
        tags    = var.node1_tags
    }

    # management {
    #     auto_upgrade = true
    #     auto_repair = true
    # }
    # upgrade_settings {
    #     max_surge = 1
    #     max_unavailable = 0
    # }
}