package com.business.pipeline.parameters

abstract class DummyMgmt { 

    def jenkinsSteps 

    def removeParameters(){ 
        
        def job = Jenkins.instance.getItemByFullName(jenkinsSteps.env.JOB_NAME)
        job.removeProperty(ParametersDefinitionProperty.class)
    }

}

