pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[url: 'https://github.com/haithem237/backendMiniProject']]
                ])
            }
        }

       stage('MVN CLEAN') {
                   steps {
                      withMaven() {
                     bat 'mvn clean compile'

                  }
                }
               }

       stage('MVN COMPILE') {
                           steps {
                               bat 'mvn compile'
                           }
                       }

                       stage('MVN PACKAGE') {
                           steps {
                               bat 'mvn package'
                           }
                       }

                       stage('MVN TEST') {
                           steps {
                               bat 'mvn test'
                           }
                       }
     stage('SonarQube Analysis') {

                      steps{
                      bat 'mvn clean verify sonar:sonar \
                             -Dsonar.projectKey=miniP \
                             -Dsonar.host.url=http://localhost:9000 \
                             -Dsonar.login=sqp_b355d21a6160d80317cb747e2f29dcefd318f7fb'
                      }





      }
    }