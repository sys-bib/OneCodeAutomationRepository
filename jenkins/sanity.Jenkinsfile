def secrets = [
  [path: 'static-secret/gc-sitefinity-automation-testing', engineVersion: 2, secretValues: [
    [envVar: 'password', vaultKey: 'password'],
    [envVar: 'BROWSERSTACK_ACCESS_KEY', vaultKey: 'BROWSERSTACK_ACCESS_KEY'],
    [envVar: 'BROWSERSTACK_USERNAME', vaultKey: 'BROWSERSTACK_USERNAME'],
    [envVar: 'PERCY_TOKEN_default', vaultKey: 'PERCY_TOKEN_default'],
    [envVar: 'PERCY_TOKEN_pmi_impact', vaultKey: 'PERCY_TOKEN_pmi-impact'],
    [envVar: 'PERCY_TOKEN_pmiscience', vaultKey: 'PERCY_TOKEN_pmiscience']
  ]]
 ]


def configuration = [vaultUrl: 'https://vault.vault-prd.shared-services.eu-west-1.aws.pmicloud.biz:8200',
                     skipSslVerification: 'true',
                     vaultCredentialId: 'vault-wfiws-prd',
                     engineVersion: 2,
                     vaultNamespace: 'wfiws-prd']

pipeline {
    agent {
        label 'windows-2019-build-agent'
    }
    tools { 
        maven 'Maven 3.8.6'
        nodejs 'NodeJs16'
    }
    environment {
        browserstack_creds = 'pmi-browserstack-creds'
        project = "${_test_project_name}"
    }
    stages {
        stage('prepare config and env') {
            steps {
               script {
                    withVault([configuration: configuration, vaultSecrets: secrets]) {
                        def percy_token_selected = "${env.PERCY_TOKEN_default}"
                        switch (env.project) {
                            case 'pmi-impact.com':
                                percy_token_selected = "${PERCY_TOKEN_pmi_impact}"
                                break
                            case 'pmiscience.com':
                                percy_token_selected = "${PERCY_TOKEN_pmiscience}"
                                break
                            default:
                                percy_token_selected = "${PERCY_TOKEN_default}"
                                break
                        }
                        env.PERCY_TOKEN = percy_token_selected
                        powershell """
                            (Get-Content -path .\\browserstack.yml -Raw) -replace ('<BROWSERSTACK_USERNAME>','${BROWSERSTACK_USERNAME}') | Set-Content -Path .\\browserstack.yml
                            (Get-Content -path .\\browserstack.yml -Raw) -replace ('<BROWSERSTACK_ACCESS_KEY>','${BROWSERSTACK_ACCESS_KEY}') | Set-Content -Path .\\browserstack.yml
                            
                            npm install
                            npm install --save-dev @percy/cli
    
                            \$Env:PERCY_TOKEN='${percy_token_selected}'
                        """
                    }
                }
            }
        }
        stage('run testing and report') {
            steps {
                    browserstack(credentialsId: 'pmi-browserstack-creds') {
                        script {
                        	if (params['Capture with Percy'])
                        	{
		                        powershell "npm run test-${project}"                        		
                        	} else {
	                            powershell "npm run test-${project}-no-percy"                  	      
                        	}
                        }
                    }
                     // Enable reporting in Jenkins
                    browserStackReportPublisher 'automate'                
            }
        }
    }
}