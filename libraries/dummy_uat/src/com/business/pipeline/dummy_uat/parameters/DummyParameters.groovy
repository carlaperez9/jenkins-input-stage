package com.business.pipeline.dummy_uat.parameters
import com.business.pipeline.parameters.Parameters

class DummyParameters implements Parameters { 

    def jenkinsSteps 
 

    DummyParameters(jenkinsSteps){
        this.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        jenkinsSteps.println "[this will create the parameters for uat]"

        if ((currentBranch == "main")){ 
            jenkinsSteps.properties([
                jenkinsSteps.parameters(addParameters())
            ])
        }
        

    def addParameters(){ 
         def parameters = [
        ]
        return parameters
    }

}