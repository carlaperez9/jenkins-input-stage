package com.business.pipeline.parameters

abstract class DummyMgmt { 

    def jenkinsSteps 

    def removeParameters(){ 
        jenkinsSteps.println "[inside-dummymgmt]"
        def job = Jenkins.instance.getItemByFullName(jenkinsSteps.env.JOB_NAME)
        job.removeProperty(ParametersDefinitionProperty.class)
    }

}

