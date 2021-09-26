pipeline {
    agent { 
        kubernetes{
            label 'jenkins-slave'
        }
        
    }
   
    stages {
        
      
        
           stage('Checkout the code') {
            steps{
                sh(script: """
                    git clone https://github.com/manishsrivastava78/demo-microservices.git
                """, returnStdout: true) 
            }
        }
		
		  stage('Build the code') {
            steps {
			      sh script: '''
                #!/bin/bash
                cd $WORKSPACE/demo-microservices/
                export M2_HOME=/usr/share/maven
                export PATH=$PATH:$M2_HOME/bin
                mvn --version
                mvn install
                '''
              }
        }
        
         stage('docker build') {
            steps{
                sh script: '''
                #!/bin/bash
                cd $WORKSPACE/demo-microservices/
                docker build -t manishsrivastava78/employees .
                '''
            }
        }
        
             
	
        
       
        

    
}
}
