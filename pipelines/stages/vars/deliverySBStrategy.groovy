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

        // def image = "google/cloud-sdk:470.0.0-alpine"
        def image ="google/cloud-sdk:470.0.0"
        def cloudsdk = docker.image(image)
        // Execute commands inside Docker container
        cloudsdk.inside {
            withCredentials([file(credentialsId: 'gke_devsu2', variable: 'GKE_CREDENTIALS_FILE')]) {
                // sh "apk add kubectl"
                // sh "gcloud components install app-engine-java kubectl"
                // sh "gcloud components install gke-gcloud-auth-plugin"
                sh "ls -l"
                sh "gcloud auth activate-service-account --key-file=${GKE_CREDENTIALS_FILE}"
                sh "gcloud container clusters get-credentials devsu-cluster-test --zone europe-west1-b --project devsu-project"
                sh "kubectl delete -f ./manifest.yaml --ignore-not-found"
                sh "kubectl apply -f ./manifest.yaml"
                sh "sleep 5"
                sh "kubectl get pods"
            }
        }

    }
}