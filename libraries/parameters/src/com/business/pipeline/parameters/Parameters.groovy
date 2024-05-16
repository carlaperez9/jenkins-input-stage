package com.business.pipeline.parameters

interface Parameters{ 

    default void create()
    
    static void removeParameters(){ 
        jenkinsSteps.println "[inside-removeparams]"
        def job = Jenkins.instance.getItemByFullName(jenkinsSteps.env.JOB_NAME)
        job.removeProperty(ParametersDefinitionProperty.class)
    }
}