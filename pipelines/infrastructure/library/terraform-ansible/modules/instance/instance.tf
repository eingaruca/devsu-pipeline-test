resource "google_compute_instance" "instance" {
    name          = var.instance_name
    zone          = var.zone
    machine_type  = var.machine_type
    deletion_protection = false
    labels        = var.labels

    # NETWORKING
    # dynamic "network_interface" {
    # for_each      = var.ip_addresses
    #     content {
    #     subnetwork         = network_interface.value.subnetwork
    #     network_ip         = network_interface.value.ip_address
    #     }
    # }

    network_interface {
        network = var.network
        
        access_config {
        }
    }

    # STORAGE
    
    boot_disk {
        auto_delete = true
        device_name = var.instance_name
        initialize_params {
          image     = var.image
          size      = var.initial_size
          type      = "pd-balanced"
        }
    }

    dynamic "attached_disk" {
      for_each = var.disks
      content {
        source        = attached_disk.value.source
        device_name   = attached_disk.value.device_name
        mode          = "READ_WRITE"
        # auto_delete   = false
      }
    }

    tags = var.network_tags
    allow_stopping_for_update = true

    # resource_policies = var.resource_policies


    
    # Others
    service_account         {
      # Google recommends custom service accounts that have cloud-platform scope and permissions granted via IAM Roles.
      # email               = "xxxx-compute@developer.gserviceaccount.com"
      email               = var.service_account
      scopes              = ["cloud-platform"]
    }   

    metadata = {
      ssh-keys = "${var.user}:${file(var.publickey)}"
    }

    connection {
      # Aquí proporcionas la configuración de conexión SSH a la instancia.
      type        = "ssh"
      user        = var.user
      private_key = file(var.privatekey)
      host        = google_compute_instance.instance.network_interface[0].access_config[0].nat_ip
    }

    provisioner "file" {
        source      = "./variables.tf"
        destination = "/tmp/test.tf"
    }
    provisioner "remote-exec" {
      inline = [ 
          "sudo apt-update -y",
          "sudo apt-get install -y ansible",
       ]
      
    }
}