import my-library.workflow.ReleaseStage 

def call(){ 
    ReleaseStage release = new ReleaseStage(this)
    release.run()
}