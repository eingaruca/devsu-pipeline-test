def call() {
    withFolderProperties{
        utils.info "deliverySBStrategy", "Springboot Strategy"
        sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"
        sh "docker build -t demosb ."
        sh "docker tag demosb eingaruca/dsb:v1"
        sh "docker push eingaruca/dsb:v1"

        sh "docker rmi demosb"
        sh "docker rmi eingaruca/dsb:v1"
        // sh 'docker rmi $(docker images -f "dangling=true" -q )'

    }
}