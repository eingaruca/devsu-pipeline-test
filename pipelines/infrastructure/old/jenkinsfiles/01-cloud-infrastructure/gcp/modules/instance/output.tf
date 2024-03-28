output "instance_output" {
  value = google_compute_instance.instance.self_link
}

output "instance_name" {
  value = google_compute_instance.instance.name
}

output "instance_ip" {
  value = google_compute_instance.instance.network_interface[0].network_ip
}