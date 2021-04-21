def call(String action)  {
    if (action == "apply") {
        pipeline {
            agent any

            tools {
                terraform 'terraform14'
            }
            parameters { choice(name: 'Environment', choices: ['', 'DEV', 'PROD'], description: 'Pick Environment') }
            stages {
                stage('INIT'){
                    steps {
                        sh '''
                        export AWS_ACCESS_KEY_ID=${AWS_USR}
                        export AWS_SECRET_ACCESS_KEY=${AWS_PSW}
                          'make $(ENVIRONMENT)-init'
                        '''
                    }
                }
                stage('APPLY') {
                    steps {
                        sh '''
                        export AWS_ACCESS_KEY_ID=${AWS_USR}
                        export AWS_SECRET_ACCESS_KEY=${AWS_PSW}
                          'make $(ENVIRONMENT)-apply'
                        '''
                    }
                }
            }
        }
    }  else {
        echo "hellow to else"
    }
}