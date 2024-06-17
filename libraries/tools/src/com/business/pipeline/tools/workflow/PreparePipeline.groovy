package com.business.pipeline.tools.workflow 

class PreparePipeline { 

    def jenkinsSteps 

    PreparePipeline(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps
    }

    def prepare(){ 
        jenkinsSteps.println "[INFO] Preparing pipeline"
        
        // read config.yaml file 
        def yaml = readYaml file: config.yaml

        jenkinsSteps.println "[INFO] End of prepare pipeline"
    }
}