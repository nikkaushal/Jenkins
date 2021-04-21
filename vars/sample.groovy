def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}

def call()  {
    pipeline {
        agent any
        stages {
            stage('Shared Library Demo') {
                steps {
                    sh 'echo hellow world'
                }
            }

        }
    }
}