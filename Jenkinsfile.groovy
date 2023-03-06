pipeline {
    agent any
    scriptPath 'Jenkinsfile.groovy'

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
