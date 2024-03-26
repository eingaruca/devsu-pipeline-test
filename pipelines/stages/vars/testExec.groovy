def call(){

    withFolderProperties {
        log.info "TestStage", "Testing project"

        unstash name: 'build'

        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        maven.inside {
            sh "java -version"

            springBootTests()
            
        }

    }

}

// def springBootTests (){
//     log.info "TestStage", ""
// }

