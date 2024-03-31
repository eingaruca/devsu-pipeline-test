def call() {
    withFolderProperties{
        utils.info "deliverySBStrategy", "Springboot Strategy"

        def image ="google/cloud-sdk:470.0.0"
        def cloudsdk = docker.image(image)
        // Execute commands inside Docker container
        cloudsdk.inside {
            withCredentials([file(credentialsId: 'gke_devsu2', variable: 'GKE_CREDENTIALS_FILE')]) {
                sh "gcloud auth activate-service-account --key-file=${GKE_CREDENTIALS_FILE}"
                sh "gcloud container clusters get-credentials devsu-cluster-test --zone europe-west1-b --project devsu-project"
                def GIT_COMMIT_HASH = sh(script: "git log -n 1 --pretty=format:'%H'", returnStdout: true).trim()[0..6]
                echo "Git commit = ${GIT_COMMIT_HASH}"
                sh "sed -i 's|TAGVARIABLE|${GIT_COMMIT_HASH}|g' manifest.yaml"
                sh "cat manifest.yaml"
                sh "kubectl delete -f ./manifest.yaml --ignore-not-found"
                sh "kubectl apply -f ./manifest.yaml"
                sh "sleep 5"
                sh "kubectl get pods"
            }
        }

    }
}