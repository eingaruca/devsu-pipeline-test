def call() {
    withFolderProperties{
        utils.info "deliverDjangoStrategy", "Django-Python Strategy"
        sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"
        sh "docker build -t demodjango ."
        sh "docker tag demodjango eingaruca/django:v1"
        sh "docker push eingaruca/django:v1"

        sh "docker rmi demodjango"
        sh "docker rmi eingaruca/django:v1"
        sh 'docker rmi $(docker images -f "dangling=true" -q )'
    }
}