void call() {
  stage("Release Details") {
    ReleaseDetails releaseDetails = new release.workflow.ReleaseDetails(this)
    releaseDetails.run()
  }
}
