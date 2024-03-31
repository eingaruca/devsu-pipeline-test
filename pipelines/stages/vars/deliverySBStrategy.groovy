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

        def GIT_COMMIT_HASH = sh(script: "git log -n 1 --pretty=format:'%H'", returnStdout: true).trim()[0..6]
        echo "Git commit = ${GIT_COMMIT_HASH}"

        sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"

        sh "docker build -t demospringb:${GIT_COMMIT_HASH} ."
        sh "docker tag demospringb:${GIT_COMMIT_HASH} eingaruca/springboot:${GIT_COMMIT_HASH}"
        sh "docker push eingaruca/springboot:${GIT_COMMIT_HASH}"

        sh "docker rmi demospringb:${GIT_COMMIT_HASH}"
        sh "docker rmi eingaruca/springboot:${GIT_COMMIT_HASH}"

    }
}