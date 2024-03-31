def call(){
    dir("${env.WORKSPACE}") {

        utils.info "CodeAnalysisStage", "Starting SonarQube Analysis Node.js Strategy"
        def scanner = tool name: 'sonarqube-scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
        // SonarQube Server Name (Jenkins Global Variable)
        def sonarqubeServer = 'sonarqube-server-2'
        // SonarQube, project name
        def project = 'Nodejs-Project'

        withSonarQubeEnv(sonarqubeServer){
            sh "echo ${pwd}"
            sh "${scanner}/bin/sonar-scanner -Dsonar.projectKey=${project} -Dsonar.sources=."
            sh 'sleep 10'
        }

        timeout(time: 5, unit: 'MINUTES') {
            utils.info "CodeAnalysisStage", "Waiting time"
            def qualityGate = waitForQualityGate()
            utils.info "CodeAnalysisStage", "qualityGate: ${qualityGate.status}"
            if ( qualityGate.status != 'OK' ) {
                utils.error "CodeAnalysisStage", "Pipeline Error, aborted due error: ${qualityGate.status}"
            }
        }
        utils.info "CodeAnalysisStage", "Finish SonarQube Analysis Node.js Strategy"
    }
}