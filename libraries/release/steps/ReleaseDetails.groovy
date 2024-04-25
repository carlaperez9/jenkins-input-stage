class ReleaseDetails{ 

    def jenkinsSteps 

    ReleaseDetails(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    void run() {
        jenkinsSteps.println "Running release details!"

    
        def myUnsortedChoices = ['4.1.0', '4.2.2', '4.3.1', '0.1.0', '0.1.1', '0.1.2']
        def message = "This is my message."
        def messageRelease = "RELEASE_VERSION_GOES_HERE"
        // def mySortedChoices = reverseOrder(myUnsortedChoices)
        reverseOrder(myUnsortedChoices)

        // Using the input step within an input block
        def myInputs = jenkinsSteps.input(
            ok: 'Confirm', // Specify an ID for the input step
            message: "${messageRelease}",
            parameters: [
                jenkinsSteps.string(name: "title", defaultValue:"", description: "My Title Goes Here. Choices are next."),
                jenkinsSteps.choice(name: "First choice", choices: myUnsortedChoices, description: "This is the first choice."), 
                jenkinsSteps.string(name: 'A String Goes Here', defaultValue: "", description: "We can place a description here")
            ]
        )

        jenkinsSteps.println "${myInputs}"
    }

    def reverseOrder(myUnsortedChoices){ 
        def version = ['1.1.0', '1.0.1', '4.0.0']
        def names   = ["myName", "myName", "myName"]

        def compareVersions = {v1, v2 -> 
            def numV1 = v1.tokenize('.').collect { it as Integer }
            def numV2 = v2.tokenize('.').collect { it as Integer }

            for (int i = 0; i < Math.min(numV1.size(), numV2.size()); i++) {
                if (numV1[i] != numV2[i]) {
                return numV2[i] <=> numV1[i] // Compare in descending order
                }
            }

        return numV2.size() <=> numV1.size()

        }
 
    }

    

    

     

    
}