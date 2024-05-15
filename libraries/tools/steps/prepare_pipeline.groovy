import com.bppr.business.pipeline.tools.workflow.PreparePipeline 

def call(){ 
    stage("Prepare Pipeline"){ 

        PreparePipeline preparePipeline = new PreparePipeline(this)
        pipeline.prepare()

    }
}