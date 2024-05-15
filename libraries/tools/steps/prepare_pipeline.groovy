import com.business.pipeline.tools.PreparePipeline

def call(){ 
    stage("Prepare Pipeline"){ 

        PreparePipeline preparePipeline = new PreparePipeline(this)
        pipeline.prepare()

    }
}