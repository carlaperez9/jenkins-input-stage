class ReleaseDetails{ 

    def jenkinsSteps 

    ReleaseDetails(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    void run(){ 
        jenkinsSteps.println "Running release details!"

        def myChocies = ['Choco', 'Platon', 'Luna']
        def message   = "This is my message."

        def myInputs  = input(
            ok: "Confirm", 
            message: "${message}", 
            parameters: [
                choice(name: 'First choice', choices: myChocies, description: "This is a dummy choice.")
            ]
        )

        jenkinsSteps.println "${myInputs}"
    }
}