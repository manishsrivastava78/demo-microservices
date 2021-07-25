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
		
		   stage('Build the code') {
				steps {
					sh script: '''
					#!/bin/bash 
					cd $WORKSPACE/demo-microservices/
				    		
					'''
					 configFileProvider([configFile(fileId: '409c7e8e-5ef0-45d2-a2aa-d476491023eb', variable: 'MAVEN_GLOBAL_SETTINGS')]) {
                   				 sh 'mvn -gs $MAVEN_GLOBAL_SETTINGS deploy'
					}
				}
			}
			
			
  
			
			
    
        
			stage('Deploy microservice') {
				steps{
					sh script: '''
						#!/bin/bash
						cd $WORKSPACE/demo-microservices/
					#get kubectl for this demo
					curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
					chmod +x ./kubectl
					./kubectl -n microservices apply -f ./configmap.yaml
					./kubectl -n microservices apply -f ./secret.yaml
					
					cat ./deployment.yaml | sed s/changeMePlease/${BUILD_NUMBER}/g | ./kubectl -n microservices  apply -f -
					 ./kubectl -n microservices apply -f ./service.yaml
					'''
				}
			}
        
			stage('GET microservice URL') {
				steps{
					sh script: '''
					#!/bin/bash
					cd $WORKSPACE/demo-microservices/
					#get kubectl for this demo
					curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
					chmod +x ./kubectl
					./kubectl get svc pf-employeesservice -o json  | jq .status.loadBalancer.ingress[0].hostname
					
					'''
					}
			}
			
			stage('Run functional tests'){
				steps{
					sh script: '''
					#!/bin/bash 
					cd $WORKSPACE/demo-microservices/
				    '''
					configFileProvider([configFile(fileId: '409c7e8e-5ef0-45d2-a2aa-d476491023eb', variable: 'MAVEN_GLOBAL_SETTINGS')]) {
                   				 sh 'mvn -gs $MAVEN_GLOBAL_SETTINGS -f test gauge:execute -DspecDir=test/specs'
					}
					
				}
			}
   	}
}
