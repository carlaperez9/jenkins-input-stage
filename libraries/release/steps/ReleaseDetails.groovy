class ReleaseDetails{ 

    def jenkinsSteps 
    def releaseTimeout 

    ReleaseDetails(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    void run() {
        jenkinsSteps.println "Running release details"
    
        try { 
        
        releaseDetails()

    } catch (Exception e){ 
        jenkinsSteps.println "${e.getMessage()}"
    } 
 
}
    
    def releaseDetails(){
        def myUnsortedChoices = ['4.1.0', '4.2.2', '4.3.1', '0.1.0', '0.1.1', '0.1.2']
        def message = "This is my message."
        def messageRelease = "RELEASE_VERSION_GOES_HERE"

        def releaseTimeout = jenkinsSteps.timeout(time: 5, unit: 'MINUTES'){ 
        jenkinsSteps.input(
        ok: 'Confirm', // Specify an ID for the input step
        message: "${messageRelease}",
        parameters: [
            jenkinsSteps.choice(name: "First choice", choices: myUnsortedChoices, description: "This is the first choice."), 
        ],  
    )    
    return releaseTimeout        
} 
    }
    def setEnvironmentVariables(releaseDetails){ 
        jenkinsSteps.env.RELEASE_DETAILS        = releaseDetails
        def (applicationName, version)          = releaseDetails.split('-')
        jenkinsSteps.env.applicationName        = applicationName 
        jenkinsSteps.env.applicationVersion     = version 
    }

 def reverseOrder(){ 
        def versions = ['1.1.0', '1.0.1', '4.0.0', '4.1.2']
        def mySortedList = []

        for (int i = 0; i <= versions.size(); i++){ 
            jenkinsSteps.println "versions[0]: ${versions[0]}"
        }
        
    }
}

    

    

     

    
