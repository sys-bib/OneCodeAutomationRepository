pipeline {
   agent {
   	label 'master-agent'
   }

    environment {
        browserstack_creds = 'pmi-browserstack-creds'
        project= "${_test_project_name}"
    }
    
    stages {
    	stage('test running') {
    		steps {
    			script {
    				browserstack(browserstack_creds) {
	    				nodejs('NodeJs14') {
							sh "npm install"
		    				sh "npm run ${project}"
		    			}
					}
	        	}
    		}
    	}
    }
 	post {
 		always {
 			cleanWs(cleanWhenNotBuilt: false, deleteDirs: true, disableDeferredWipout: true, notFailBuild: false)
 		}
 	}
 }