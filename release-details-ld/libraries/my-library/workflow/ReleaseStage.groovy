package my-library.workflow.ReleaseStage 

class ReleaseStage{ 
    
    def jenkinsSteps 

    ReleaseStage(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps
    }

    void run(){ 
        stage("Release Stage"){
            jenkinsSteps.println "Running."
        }
    }
}