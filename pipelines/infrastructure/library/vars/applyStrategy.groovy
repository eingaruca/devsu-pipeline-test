def call (dirResources, instanceNameVar, projectVar) {
    withFolderProperties {
        dir (dirResources) {
            sh "terraform apply -var 'instance_name=${instanceNameVar}' -var 'project=${instanceNameVar}' -var 'credentials=${utils.credentials()}' -var 'region=${utils.region()}' -var 'zone=${utils.zone()}' --auto-approve"
        }
    }
}