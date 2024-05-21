class ReleaseDetails{ 

    def jenkinsSteps 
    def submitters = jenkinsSteps.pipelineConfig.submitters.approved_submitter

    ReleaseDetails(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    void run() {
        jenkinsSteps.println "Running release details!"

    
        def myUnsortedChoices = ['4.1.0', '4.2.2', '4.3.1', '0.1.0', '0.1.1', '0.1.2']
        def message = "This is my message."
        def messageRelease = "RELEASE_VERSION_GOES_HERE"

        
        // def mySortedChoices = reverseOrder(myUnsortedChoices)
        reverseOrder()
        

        try { 
        // Using the input step within an input block
        def input 
        def releaseTimeout = jenkinsSteps.timeout(time: 5, unit: 'MINUTES'){ 
                jenkinsSteps.input(
                ok: 'Confirm', // Specify an ID for the input step
                message: "${messageRelease}",
                parameters: [
                    jenkinsSteps.choice(name: "First choice", choices: myUnsortedChoices, description: "This is the first choice."), 
                ], 
                submitter: "$submitters",
                submitterParameter: "approvedBy"
            )            
        } 
        jenkinsSteps.println "submitters: ${releaseTimeout.submitters}"
        jenkinsSteps.println "approvedBy: ${releaseTimeout.approvedBy}"

        if (releaseTimeout.approvedBy != submitters){ 
            jenkinsSteps.println "THIS SHOULD THROW AN ERROR"
        }

    } catch (Exception e){ 
        jenkinsSteps.println "${e.getMessage()}"
    }

   
 
}
 def reverseOrder(){ 
        def versions = ['1.1.0', '1.0.1', '4.0.0', '4.1.2']
        def mySortedList = []

        for (int i = 0; i <= versions.size(); i++){ 
            jenkinsSteps.println "versions[0]: ${versions[0]}"
        }
        
    }
}

    

    

     

    
