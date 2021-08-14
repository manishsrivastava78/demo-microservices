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
                   				 sh 'mvn -gs $MAVEN_GLOBAL_SETTINGS install'
					}
				}
			}
			
			
stage('Code Quality Check via SonarQube') {
 steps {
    script {
       def scannerHome = tool 'sonarqubeScanner';
           withSonarQubeEnv("sonarqube_server") {
           sh "${tool("sonarqubeScanner")}/bin/sonar-scanner \
           -Dsonar.projectKey=demo-microservice \
           -Dsonar.sources=. \
           -Dsonar.java.binaries=."
		   }
         }
       }
	}
        
	    stage("Quality Gate"){
		    steps {
    script {
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}
		    }}	    
			stage('docker build') {
				steps{
					sh script: '''
					#!/bin/bash
					cd $WORKSPACE/demo-microservices/
					docker build -t manishsrivastava78/employees:${BUILD_NUMBER} .
					'''
				}
			}
                    
			stage('docker login') {
				steps{
					sh(script: """
						docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
					""", returnStdout: true) 
				}
			}
        
            stage('Push docker image') {
				steps{
					sh(script: """
						docker push manishsrivastava78/employees:${BUILD_NUMBER}
					""")
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
					./kubectl apply -f ./configmap.yaml
					./kubectl apply -f ./secret.yaml
					
					cat ./deployment.yaml | sed s/changeMePlease/${BUILD_NUMBER}/g | ./kubectl apply -f -
					 ./kubectl apply -f ./service.yaml
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
   	}
}
