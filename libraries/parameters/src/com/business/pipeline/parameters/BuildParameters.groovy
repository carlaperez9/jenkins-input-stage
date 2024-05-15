package com.business.pipeline.parameters

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
        jenkinsSteps.println "[INFO] Libraries: ${jenkinsSteps.pipelineConfig.libraries}"
        if (jenkinsSteps.pipelineConfig.libraries.containsKey("dummy_dev")){ 
            returnedParameters = "dummy dev params"
        } else if (jenkinsSteps.pipelineConfig.libraries.containsKey("dummy_prd")){ 
            returnedParameters = "dummy prd params"
        } else if (jenkinsSteps.pipelineConfig.libraries.containsKey("dummy_uat")){
            returnedParameters = "dummy uat params"
        } else { 
            jenkinsSteps.println "no params"
        }
        Parameters parameters = jenkinsSteps.class.classLoader.loadClass(returnedParameters).newInstance(jenkinsSteps) as Parameters
        jenkinsSteps.println "parameters class: ${parameters}"
        return returnedParameters
    }
 
}