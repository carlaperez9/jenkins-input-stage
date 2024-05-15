package com.business.pipeline.dummy_prd.parameters
import com.business.pipeline.parameters.Parameters

class DummyParameters implements Parameters { 

    def jenkinsSteps 

    DummyParameters(jenkinsSteps){
        this.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        jenkinsSteps.println "[this will create the parameters for prd]"
    }
}