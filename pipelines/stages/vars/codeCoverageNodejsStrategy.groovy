def call() {
    withFolderProperties{
        utils.info "CodeCoverageStage", "Node.js Strategy"
    }
}



def call() {
    withFolderProperties {
        utils.info "CodeCoverageStage", "Node.js Strategy"

        // Define Docker image
        def image = "node:alpine"
        def node = docker.image(image)

        // Execute commands inside Docker container
        node.inside {
            unstash name: 'build'
            sh "npm install" 
            sh "npm run test"

            // Ejecutar pruebas con cobertura
            sh "npx nyc --reporter=lcov npm run test"

            // Generar informe de cobertura en HTML
            sh "npx nyc report --reporter=html"
        }

        // Archivar resultados de pruebas JUnit (si aplicable)
        step([$class: 'JUnitResultArchiver', testResults: '**/junit.xml'])

        // Publicar informe de cobertura en HTML
        publishHTML(target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'coverage',
            reportFiles: 'index.html',
            reportName: "Code Coverage Report"
        ])

        utils.info "CodeCoverageStage", "Finish Node.js Strategy"
    }
}
