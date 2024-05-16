package com.business.pipeline.dummy_uat.parameters
import com.business.pipeline.parameters.Parameters

class DummyParameters implements Parameters { 

    def jenkinsSteps 
    def currentBranch = jenkinsSteps.env.BRANCH_NAME.toLowerCase()
 

    DummyParameters(jenkinsSteps){
        this.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        jenkinsSteps.println "[recreating error]"

        if ((currentBranch == "main")){ 
            jenkinsSteps.properties([
                jenkinsSteps.parameters(addParameters())
            ])
        } 
    }

     def addParameters(){ 
        def parameters = [
            jenkinsSteps.booleanParam(name: 'working_parameters', defaultValue: false, description: 'This is a dummy.')
        ]
        return parameters
    }

}
