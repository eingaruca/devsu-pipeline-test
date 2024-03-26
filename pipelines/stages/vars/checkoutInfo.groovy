def call () {
    withFolderProperties {
        def branchName = scm.getBranches()[0].getName()
        def gitCommit = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()

        log.info("CheckoutStage", "BRANCH: ${branchName}")
        log.info("CheckoutStage", "COMMIT: ${gitCommit}")

    }
}