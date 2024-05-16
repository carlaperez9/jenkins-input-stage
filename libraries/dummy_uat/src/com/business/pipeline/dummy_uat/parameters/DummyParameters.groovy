package com.business.pipeline.dummy_uat.parameters
import com.business.pipeline.parameters.Parameters
import com.business.pipeline.parameters.DummyMgmt

class DummyParameters extends DummyMgmt implements Parameters { 

    def jenkinsSteps 

    DummyParameters(jenkinsSteps){
        this.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        // jenkinsSteps.println "[This build does not require parameters-Create]"

        jenkinsSteps.println "[recreating error]"
        
        jenkinsSteps.properties([
            jenkinsSteps.parameters(addParameters())
        ])

        // super.removeParameters()
    }

    def addParameters(){ 
        def parameters = [
            jenkinsSteps.booleanParam(name: 'working_parameters', defaultValue: false, description: 'This is a dummy.')
        ]
        return parameters
    }


}
