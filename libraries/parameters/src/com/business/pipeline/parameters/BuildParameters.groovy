package com.business.pipeline.parameters

import com.business.pipeline.parameters.Parameters

class BuildParameters{

    def jenkinsSteps 
    Parameters param


    BuildParameters(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
        this.param = this.getParameters(jenkinsSteps)
    }

    def create(){ 
        jenkinsSteps.println "[INFO] Created parameters"
        this.param.create()
    }
    // TODO: dynamically load the parameters for each class 
    @NonCPS
    private Parameters getParameters(jenkinsSteps){ 
        String returnedParameters = null 
        def parameters = null

        jenkinsSteps.println "[INFO] Libraries: ${jenkinsSteps.pipelineConfig.libraries}"
        if (jenkinsSteps.pipelineConfig.libraries.containsKey("dummy_dev")){ 
            returnedParameters = "com.business.pipeline.dummy_dev.parameters.DummyParameters"
        } else if (jenkinsSteps.pipelineConfig.libraries.containsKey("dummy_prd")){ 
            returnedParameters = "com.business.pipeline.dummy_prd.parameters.DummyParameters"
        } else { 
            jenkinsSteps.println "[INFO] This build does not require parameters."
            def job = Jenkins.instance.getItemByFullName(jenkinsSteps.env.JOB_NAME)
            job.removeProperty(ParametersDefinitionProperty.class)
        }

        if (returnedParameters != null){ 
            parameters = jenkinsSteps.class.classLoader.loadClass(returnedParameters).newInstance(jenkinsSteps) as Parameters
            jenkinsSteps.println "parameters class: ${parameters}"
        }


        return parameters
    }
 
}