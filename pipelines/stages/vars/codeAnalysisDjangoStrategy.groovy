// def call(projectType){
//     if ( projectType == "springboot" ) runSonarqubeSB()
// }


def call(){
    dir("${env.WORKSPACE}") {
        def scanner = tool name: 'sonarqube-scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
        withSonarQubeEnv('sonarqube-server-2'){
            echo "$pwd"
            sh "java -version"
            sh "${scanner}/bin/sonar-scanner -Dsonar.projectKey=Java-Project -Dsonar.java.binaries=target/classes"
            sh 'sleep 10'
        }

        timeout(time: 5, unit: 'MINUTES') {
            utils.info "CodeAnalysisStage", "Waiting time"
            def qualityGate = waitForQualityGate()
            utils.info "CodeAnalysisStage", "qualityGate: ${qualityGate.status}"
            if ( qualityGate.status != 'OK' ) {
                error "Pipeline Error, aborted due error: ${qualityGate.status}"
            }
        }

    }
}


// Testing running Sonar as Docker container
def runSonarqubeSB_containermode(){
    utils.info "CodeAnalysisStage", "Starting SonarQube Analysis - SpringBoot Code"

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