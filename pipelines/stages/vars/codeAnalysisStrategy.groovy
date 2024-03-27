def call(projectType){
    if ( projectType == "springboot" ) runSonarqubeSB()
}


def runSonarqubeSB(){
    dir("${env.WORKSPACE}") {
        def scanner = tool name: 'sonarqube-scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
        withSonarQubeEnv('sonarqube-server-2'){
            echo "$pwd"
            sh "java -version"
            // sh "curl -v telnet://172.17.0.3:9000"
            // sh "curl -v telnet://sonarqube-docker_sonarqube_1:9000"
            // sh "whoami"
            // sh "hostname"
            sh "${scanner}/bin/sonar-scanner -Dsonar.projectKey=Java-Project -Dsonar.java.binaries=target/classes"
            sh 'sleep 10'
        }

        timeout(time: 5, unit: 'MINUTES') {
            log.info "CodeAnalysisStage", "Waiting time"
            def qualityGate = waitForQualityGate()
            log.info "CodeAnalysisStage", "qualityGate: ${qualityGate.status}"
            if ( qualityGate != 'OK' ) {
                error "Pipeline Error, aborted due error: ${qualityGate.status}"
            }
        }

    }
}

def runSonarqubeSB_containermode(){
    log.info "CodeAnalysisStage", "Starting SonarQube Analysis - SpringBoot Code"

    withSonarQubeEnv('sonarqube-server'){
        echo "$pwd"
        unstash name : 'build'
        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        def branch_name = "dev"

        maven.inside {
            sh "java -version"
            sh "mvn -f ${env.WORKSPACE}/pom.xml verify sonar:sonar -Dsonar.branch=${branch_name} -Dmaven.test.skip=true"
        }

    }

}