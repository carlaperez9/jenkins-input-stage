package com.business.pipeline.dummy_uat.parameters
import com.business.pipeline.parameters.Parameters
import com.business.pipeline.parameters.DummyMgmt

class DummyParameters extends DummyMgmt implements Parameters { 

    def jenkinsSteps 
    def currentBranch = jenkinsSteps.env.BRANCH_NAME.toLowerCase()
 

    DummyParameters(jenkinsSteps){
        super.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        jenkinsSteps.println "[This build does not require parameters-Create]"
        removeParameters()
    }


}
