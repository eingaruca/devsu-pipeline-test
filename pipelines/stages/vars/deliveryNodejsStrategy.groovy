def call() {
    withFolderProperties{
        utils.info "deliverNodejsStrategy", "Node.js Strategy"

        def GIT_COMMIT_HASH = sh(script: "git log -n 1 --pretty=format:'%H'", returnStdout: true).trim()[0..6]
        echo "Git commit = ${GIT_COMMIT_HASH}"

        sh "docker login -u eingaruca -p dckr_pat_I1tZsF5F4aAq-mq9kZSmp3SaGXA"

        sh "docker build -t demonodejs:${GIT_COMMIT_HASH} ."
        sh "docker tag demonodejs:${GIT_COMMIT_HASH} eingaruca/nodejs:${GIT_COMMIT_HASH}"
        sh "docker push eingaruca/nodejs:${GIT_COMMIT_HASH}"

        sh "docker rmi demonodejs:${GIT_COMMIT_HASH}"
        sh "docker rmi eingaruca/nodejs:${GIT_COMMIT_HASH}"

        // sh 'docker rmi $(docker images -f "dangling=true" -q )'
    }
}