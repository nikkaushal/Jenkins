def call(action)  {
    if (action == "apply") {
        pipeline {
            agent any
            stages {
                stage('INIT'){
                    steps {
                        sh '''
                        export AWS_ACCESS_KEY_ID=${AWS_USR}
                        export AWS_SECRET_ACCESS_KEY=${AWS_PSW}
                          'make dev-init'
                        '''
                    }
                }
                stage('APPLY') {
                    steps {
                        sh '''
                        export AWS_ACCESS_KEY_ID=${AWS_USR}
                        export AWS_SECRET_ACCESS_KEY=${AWS_PSW}
                          'make dev-apply'
                        '''
                    }
                }
            }
        }
    }  else {
        echo "hellow to else"
    }
}