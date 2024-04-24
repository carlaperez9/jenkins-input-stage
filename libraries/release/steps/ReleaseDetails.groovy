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
        def myInputs = input(
            id: 'userInput', // Specify an ID for the input step
            message: "${message}",
            parameters: [
                choice(name: 'First choice', choices: myChoices, description: "This is a dummy choice.")
            ]
        )

        jenkinsSteps.println "${myInputs}"
    }   
}