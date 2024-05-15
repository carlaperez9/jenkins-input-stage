package com.business.pipeline.dummy_uat 

class DummyParameters implements Parameters { 

    def jenkinsSteps 

    DummyParameters(jenkinsSteps){
        this.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        jenkinsSteps.println "[this will create the parameters for uat]"
    }
}