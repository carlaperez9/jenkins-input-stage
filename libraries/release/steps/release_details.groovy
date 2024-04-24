import release.workflow.ReleaseDetails

void call() {
  stage("Release Details") {
    ReleaseDetails releaseDetails = new ReleaseDetails(this)
    releaseDetails.run()
  }
}
