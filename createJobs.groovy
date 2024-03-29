pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}
pipelineJob('theme-park-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/klesiossss/business-api-cicd.git'
                    }
                    branch 'develop'
                }
            }
        }
    }
}
pipelineJob('theme-park-job-docker') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/klesiossss/business-api-cicd.git'
                    }
                    branch 'develop'
                    scriptPath('Jenkinsfile-docker')
                }
            }
        }
    }
}
pipelineJob('theme-park-job-aws') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/klesiossss/business-api-cicd.git'
                    }
                    branch 'develop'
                    scriptPath('Jenkinsfile-aws')
                }
            }
        }
    }
}