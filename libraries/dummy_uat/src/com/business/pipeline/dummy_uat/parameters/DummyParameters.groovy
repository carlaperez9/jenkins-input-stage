package com.business.pipeline.dummy_uat.parameters
import com.business.pipeline.parameters.Parameters

class DummyParameters implements Parameters { 

    def jenkinsSteps 
    def currentBranch = jenkinsSteps.env.BRANCH_NAME.toLowerCase()
 

    DummyParameters(jenkinsSteps){
        this.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        jenkinsSteps.println "[this will create the parameters for uat]"

        if (currentBranch !== "main"){ 
            jenkinsSteps.properties([
                jenkinsSteps.parameters(addParameters())
            ])
        }
    }
        

    def addParameters(){ 
         def parameters = jenkinsSteps.println "This build does not require parameters."
        return parameters
    }

}
