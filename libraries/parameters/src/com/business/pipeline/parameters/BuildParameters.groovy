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
        String returnedParameters = ""
        def parameters
        jenkinsSteps.println "[INFO] Libraries: ${jenkinsSteps.pipelineConfig.libraries}"
        if (jenkinsSteps.pipelineConfig.libraries.containsKey("dummy_dev")){ 
            returnedParameters = "com.business.pipeline.dummy_dev.parameters.DummyParameters"
        } else if (jenkinsSteps.pipelineConfig.libraries.containsKey("dummy_prd")){ 
            returnedParameters = "com.business.pipeline.dummy_prd.parameters.DummyParameters"
        } else { 
            parameters = jenkinsSteps.println "no params"
        }
        parameters = jenkinsSteps.class.classLoader.loadClass(returnedParameters).newInstance(jenkinsSteps) as Parameters
        jenkinsSteps.println "parameters class: ${parameters}"
        return parameters
    }
 
}