pipeline {
    agent any
    scriptPath 'Jenkinsfile.txt'

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
