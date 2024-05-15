import com.business.pipeline.parameters.BuildParameters

def call(){ 
    BuildParameters buildParameters = new BuildParameters(this)
    buildParameters.create()
}