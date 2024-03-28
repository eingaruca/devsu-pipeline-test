module "instance-test-ora" {
  # Module
  source                = "./modules/instance"
  #Basics
  instance_name         = "instancia-test"
  machine_type          = "n1-standard-1"
  image                 = "debian-cloud/debian-11"
  zone                  = var.zone
  region                = var.region
  # Networking
  subnetwork            = "projects/devsu-project/regions/europe-west1/subnetworks/default"
  ip_addresses          = [ 
                            { ip_address = "10.132.0.10"  , subnetwork = "projects/devsu-project/regions/europe-west1/subnetworks/default"}
                          ]
  # Storage
  initial_size          = "50"

  disks                 = [ ]
  # Metadata 
  network_tags          = [ ]
  labels                = {
                            customer-id     = "devsu"
                            environment     = "test"
                            service-type    = "sonarqube"
                          }

  # Others
  service_account       = "admin-sa-devsuproject@devsu-project.iam.gserviceaccount.com"
}