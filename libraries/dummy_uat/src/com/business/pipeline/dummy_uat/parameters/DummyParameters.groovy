package com.business.pipeline.dummy_uat.parameters
import com.business.pipeline.parameters.Parameters

class DummyParameters implements Parameters { 

    def jenkinsSteps 
    def currentBranch = jenkinsSteps.env.BRANCH_NAME.toLowerCase()
 

    DummyParameters(jenkinsSteps){
        this.jenkinsSteps = jenkinsSteps 
    }

    void create(){ 
        jenkinsSteps.println "this build does not require parameters"
        // def job = Jenkins.instance.getItemByFullName(jenkinsSteps.env.JOB_NAME)
        // job.removeProperty(ParametersDefinitionProperty.class)
    }

}
