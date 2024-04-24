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
            parameters: [
                jenkinsSteps.choice(name: "First choice", choices: myChoices, description: "This is the first choice."), 
                jenkinsSteps.choice(name: "Second choice", choices: myChoices, description: "This is the second choice."),
            ]
        )

        jenkinsSteps.println "${myInputs}"
    }   
}