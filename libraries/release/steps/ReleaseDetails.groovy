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
        def mySortedChoices = reverseOrder(myUnsortedChoices)

        // Using the input step within an input block
        def myInputs = jenkinsSteps.input(
            ok: 'Confirm', // Specify an ID for the input step
            message: "${messageRelease}",
            parameters: [
                jenkinsSteps.string(name: "title", defaultValue:"", description: "My Title Goes Here. Choices are next."),
                jenkinsSteps.choice(name: "First choice", choices: mySortedChoices, description: "This is the first choice."), 
                jenkinsSteps.string(name: 'A String Goes Here', defaultValue: "", description: "We can place a description here")
            ]
        )

        jenkinsSteps.println "${myInputs}"
    }

    def reverseOrder(myUnsortedChoices) {
        def mySortedChoices = myUnsortedChoices.sort { a, b -> compareVersions(b, a) }
        return mySortedChoices
    }

    def compareVersions(version1, version2) {
        def v1 = version1.tokenize('.').collect { it.toString() }
        def v2 = version2.tokenize('.').collect { it.toString() }

        // Compare each version component starting from left to right
        for (int i = 0; i < Math.min(v1.size(), v2.size()); i++) {
            if (v1[i] != v2[i]) {
                return v1[i] <=> v2[i]
            }
        }
        
        // If all components are equal up to this point, the longer version is considered higher
        return v1.size() <=> v2.size()
    }

     

    
}