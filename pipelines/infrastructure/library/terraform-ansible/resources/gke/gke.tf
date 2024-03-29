provider "google" {
  credentials     = var.credentials
  project         = var.project
}

module "devsu-cluster"{
    source              = "../../modules/k8s"
    cluster_name        = var.instance_name
    gke_version         = "1.27.8-gke.1067004"
    location            = var.region
    node_locations      = [var.zone]
    # node_count_pool1    = 1
    network             = "projects/devsu-project/global/networks/default"
    subnetwork          = "projects/devsu-project/regions/europe-west1/subnetworks/default"
    # master_range_allow  = "10.1.1.0/24"
    # machine_type        = "n1-standard-1"
    resource_labels             = { "name" = "devsu-cluster-test" }
    node1_labels                = { "name" = "pool-1" }

}