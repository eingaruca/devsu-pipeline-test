def call(){

    withFolderProperties {
        log.info "TestStage", "Testing project"

        unstash name: 'build'

        def image = "maven:3.8.3-openjdk-17"
        def maven = docker.image(image)
        maven.inside {
            sh "java -version"

            // testStrategy.springBootTests()
            // parallel(
            //     "Unit Tests": { testStrategy.sbUnitTest() },
            //     "Acceptance Tests": { testStrategy.sbAcceptanceTest() },
            //     "Integration Tests": { testStrategy.sbIntegrationTest() },
            //     failFast: true
            // )
            testStrategy.springBootTests()
        }

    }

}