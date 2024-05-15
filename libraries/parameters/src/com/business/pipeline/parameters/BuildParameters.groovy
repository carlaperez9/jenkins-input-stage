package com.business.pipeline.parameters

class BuildParameters{

    def jenkinsSteps 


    BuildParameters(jenkinsSteps){ 
        this.jenkinsSteps = jenkinsSteps 
    }

    def create(){ 
        jenkinsSteps.println "[INFO] Created parameters"
    }
 
}