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

        myUnsortedChoices.each { 
            jenkinsSteps.println "${myUnsortedChoices[0]}"
        }

    }

    

    

     

    
}