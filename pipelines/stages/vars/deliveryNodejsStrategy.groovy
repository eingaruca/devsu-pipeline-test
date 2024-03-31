def call() {
    withFolderProperties{
        utils.info "deliverNodejsStrategy", "Node.js Strategy"
        sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"
        sh "docker build -t demonodejs ."
        sh "docker tag demonodejs eingaruca/nodejs:v1"
        sh "docker push eingaruca/nodejs:v1"

        sh "docker rmi demonodejs"
        sh "docker rmi eingaruca/nodejs:v1"




        sh "docker build -t demonodejs ."
        sh "docker tag demonodejs eingaruca/nodejs:v1.1"
        sh "docker push eingaruca/nodejs:v1.1"

        sh "docker rmi demonodejs"
        sh "docker rmi eingaruca/nodejs:v1.1"
        // sh 'docker rmi $(docker images -f "dangling=true" -q )'
    }
}