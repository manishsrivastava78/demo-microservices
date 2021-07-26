pipeline {
   		agent { 
            kubernetes{
                label 'jenkins-slave'
        }
     }
      
    environment{
        DOCKER_USERNAME = credentials('DOCKER_USERNAME')
        DOCKER_PASSWORD = credentials('DOCKER_PASSWORD')
    }
    stages {
			stage('Checkout the code') {
				steps{
					sh(script: """
					   git clone https://github.com/manishsrivastava78/demo-microservices.git
					""", returnStdout: true) 
				}
			}
		
		 
			
			stage('Run functional tests'){
				steps{
					sh script: '''
					#!/bin/bash 
					cd $WORKSPACE/demo-microservices/
				    '''
					configFileProvider([configFile(fileId: '409c7e8e-5ef0-45d2-a2aa-d476491023eb', variable: 'MAVEN_GLOBAL_SETTINGS')]) {
						sh 'gauge --version'
                   				 sh 'mvn -gs $MAVEN_GLOBAL_SETTINGS -f test gauge:execute -DspecDir=test/specs'
					}
					
				}
			}
   	}
}
