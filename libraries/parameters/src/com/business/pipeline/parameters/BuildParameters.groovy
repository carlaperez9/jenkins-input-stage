package com.business.pipeline.parameters

class BuildParameters{

    def jenkinsSteps 


    BuildParameters(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    def create(){ 
        jenkinsSteps.println "[INFO] Created parameters"
        getParameters(jenkinsSteps)
    }

    def getParameters(jenkinsSteps){ 
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
        return returnedParameters
    }
 
}