def call (dirResources, instanceNameVar, projectVar) {
    withFolderProperties {
        dir (dirResources) {
            sh "terraform plan -var 'instance_name=${instanceNameVar}' -var 'project=${projectVar}' -var 'credentials=${utils.credentials()}' -var 'region=${utils.region()}' -var 'zone=${utils.zone()}'"
        }
    }
}