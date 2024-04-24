package release.workflow 

class ReleaseDetails(){ 

    def jenkinsSteps 

    ReleaseDetails(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    void run(){ 
        jenkinsSteps.println "Running release details!"
    }

}