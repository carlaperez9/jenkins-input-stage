class ReleaseDetails{ 

    def jenkinsSteps 

    ReleaseDetails(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    void run() {
        jenkinsSteps.println "Running release details!"

        def myChoices = ['Choco', 'Platon', 'Luna']
        def message = "This is my message."

        // Using the input step within an input block
        def myInputs = jenkinsSteps.input(
            id: 'userInput', // Specify an ID for the input step
            message: "${message}",
        )

        jenkinsSteps.println "${myInputs}"
    }   
}