def call() {
    withFolderProperties{
        utils.info "deliverDjangoStrategy", "Django-Python Strategy"
        // sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"
        // sh "docker build -t demodjango ."
        // sh "docker tag demodjango eingaruca/django:v1"
        // sh "docker push eingaruca/django:v1"

        // sh "docker rmi demodjango"
        // sh "docker rmi eingaruca/django:v1"
        // sh 'docker rmi $(docker images -f "dangling=true" -q )'


        def GIT_COMMIT_HASH = sh(script: "git log -n 1 --pretty=format:'%H'", returnStdout: true).trim()[0..6]
        echo "Git commit = ${GIT_COMMIT_HASH}"

        sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"

        sh "docker build -t demodjango:${GIT_COMMIT_HASH} ."
        sh "docker tag demodjango:${GIT_COMMIT_HASH} eingaruca/django:${GIT_COMMIT_HASH}"
        sh "docker push eingaruca/django:${GIT_COMMIT_HASH}"

        sh "docker rmi demodjango:${GIT_COMMIT_HASH}"
        sh "docker rmi eingaruca/django:${GIT_COMMIT_HASH}"
    }
}