package com.business.pipeline.tools.workflow 

class PreparePipeline { 

    def jenkinsSteps 

    PreparePipeline(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps
    }

    def prepare(){ 
        jenkinsSteps.println "[INFO] Preparing pipeline"
        jenkinsSteps.build_parameters(jenkinsSteps)
        jenkinsSteps.println "[INFO] End of prepare pipeline"
    }
}