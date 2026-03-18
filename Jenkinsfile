pipeline 
{
    agent any
    
    tools{
        maven 'maven'
        }

    stages 
    {
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
        
        
                
        stage('Regression Automation Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/PJagtap243/OnlineShoppingProject.git'
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/resources/com/runners/testng.xml"
                    
                }
            }
        }
                
     
        stage('Publish Allure Reports') {
           steps {
                echo("deploy to qa")
            }
        }
        
        stage("Deploy to Stage"){
            steps{
                echo("deploy to Stage")
            }
        }
        
        
    }
}