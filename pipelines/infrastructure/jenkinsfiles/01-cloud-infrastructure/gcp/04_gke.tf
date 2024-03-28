module "devsu-cluster"{
    source              = "../modules/k8s"
    cluster_name        = "devsu-cluster"
    gke_version         = "1.27.8-gke.1067004"
    location            = var.region
    node_locations      = [var.zone]
    cluster_range       = "10.5.1.0/28"
    node_count_pool1    = 0
    network             = "projects/static-manifest-379416/global/networks/mi-red"
    subnetwork          = "projects/devsu-project/regions/europe-west1/subnetworks/default"
    master_range_allow  = "10.1.1.0/24"
    # machine_type        = "n1-standard-1"
    # Metadata
    resource_labels             = { "scheduler" = "12x5", "name" = "gke-test" }
    node1_labels                = { "scheduler" = "12x5", "name" = "pool-1"   }
    node1_tags                  = [ "node-pool","pool-1","allow-http","load-balanced-backend" ]
    # node1_enable_autoscaling    = false
    # node2_enable_autoscaling    = false
}