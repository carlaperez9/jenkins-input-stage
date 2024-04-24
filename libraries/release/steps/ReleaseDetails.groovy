class ReleaseDetails{ 

    def jenkinsSteps 

    ReleaseDetails(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    void run() {
        jenkinsSteps.println "Running release details!"

        def myChoices = ['Choco', 'Platon', 'Luna']
        def message = "This is my message."
        def messageRelease = "RELEASE_VERSION_GOES_HERE"

        // Using the input step within an input block
        def myInputs = jenkinsSteps.input(
            ok: 'Confirm', // Specify an ID for the input step
            message: "${message}",
            parameters: [
                jenkinsSteps.choice(name: "First choice", choices: myChoices, description: "This is the first choice."), 
                jenkinsSteps.string(name: 'A String Goes Here', defaultValue: "", description: "We can place a description here")
            ]
        )

        jenkinsSteps.println "${myInputs}"
    }   
}