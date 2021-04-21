def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}

def terraform() {
    pipeline {
        agent any
        stages {
            stage('Shared Library Demo') {
                steps {
                    script {
                        print 'Hello'

                    }
                }
            }

        }
    }
}