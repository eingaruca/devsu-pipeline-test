def call() {
    withFolderProperties{
        utils.info "deliverySBStrategy", "Springboot Strategy"
        // sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"
        // sh "docker build -t demosb ."
        // sh "docker tag demosb eingaruca/dsb:v1"
        // sh "docker push eingaruca/dsb:v1"

        // sh "docker rmi demosb"
        // sh "docker rmi eingaruca/dsb:v1"
        // sh 'docker rmi $(docker images -f "dangling=true" -q )'

        def image = "google/cloud-sdk:470.0.0-alpine"
        def cloudsdk = docker.image(image)
        // Execute commands inside Docker container
        cloudsdk.inside {
            sh "gcloud auth activate-service-account --key-file=${env.gke_devsu}"
            sh "kubectl get pods"
            
        }

    }
}