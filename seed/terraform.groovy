///
folder('Terraform-Releases') {
    displayName('Terraform-Releases')
    description('Terraform-Releases')
}

pipelineJob('Terraform-Releases/VPC') {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/nikkaushal/terraform-vpc.git')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/main')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
}

pipelineJob('Terraform-Releases/FRONTEND') {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/nikkaushal/terraform-frontend.git')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/master')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
}

pipelineJob('Terraform-Releases/ALB') {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/nikkaushal/terraform-alb.git')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/master')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
}