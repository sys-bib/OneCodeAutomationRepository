def secrets = [
  [path: 'static-secret/gc-platform-automation-testing', engineVersion: 2, secretValues: [
    [envVar: 'password', vaultKey: 'password'],
    [envVar: 'BROWSERSTACK_ACCESS_KEY', vaultKey: 'BROWSERSTACK_ACCESS_KEY'],
    [envVar: 'BROWSERSTACK_USERNAME', vaultKey: 'BROWSERSTACK_USERNAME'],
    [envVar: 'PERCY_TOKEN_default.com', vaultKey: 'PERCY_TOKEN_default.com'],
    [envVar: 'PERCY_TOKEN_pmi-impact.com', vaultKey: 'PERCY_TOKEN_pmi-impact.com'],
    [envVar: 'PERCY_TOKEN_pmiscience.com', vaultKey: 'PERCY_TOKEN_pmiscience.com'],
    [envVar: 'PERCY_TOKEN_unsmokeyourworld.com', vaultKey: 'PERCY_TOKEN_unsmokeyourworld.com']
  ]]
 ]

def configuration = [vaultUrl: 'https://vault.vault-prd.shared-services.eu-west-1.aws.pmicloud.biz:8200',
                     skipSslVerification: 'true',
                     vaultCredentialId: 'vault-igcpes-prd',
                     engineVersion: 2,
                     vaultNamespace: 'igcpes-prd']

pipeline {
    agent any
    environment {
        browserstack_creds = 'pmi-browserstack-creds'
        project = "${_test_project_name}"
        PERCY_TOKEN = "${PERCY_TOKEN_default.com}"
    }
    stages {
        stage('Config setup') {
            steps {
                script {
                    /* groovylint-disable-next-line NestedBlockDepth */
                    withVault([configuration: configuration, vaultSecrets: secrets]) {
                        switch (env.project) {
                            case 'pmi-impact.com':
                                env.PERCY_TOKEN = "${PERCY_TOKEN_pmi-impact.com}"
                                break
                            case 'pmiscience.com':
                                env.PERCY_TOKEN = "${PERCY_TOKEN_pmiscience.com}"
                                break
                            default:
                            env.PERCY_TOKEN = "${PERCY_TOKEN_default.com}"
                                break
                        }
                        sh """
                            export PERCY_TOKEN=${env.PERCY_TOKEN}
                            sed -i "s/<BROWSERSTACK_USERNAME>/${BROWSERSTACK_USERNAME}/" browserstack.yml
                            sed -i "s/<BROWSERSTACK_ACCESS_KEY>/${BROWSERSTACK_ACCESS_KEY}/" browserstack.yml
                        """
                    }
                }
            }
        }
        stage('Run Testing') {
            steps {
                nodejs('NodeJs14') {
                    sh 'npm install'
                    sh "npm run test-${project}"
                }
            }
        }
        post {
            always {
                cleanWs(cleanWhenNotBuilt: false, deleteDirs: true, disableDeferredWipout: true, notFailBuild: false)
            }
        }
    }
}
