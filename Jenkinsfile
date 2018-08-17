application = env.APP_NAME
applicationId = env.APP_ID

// Declare microservice name
microservice = env.MICROSERVICE_NAME

// Collect the git info (Since the git plugin has trouble providing the URL and commit hash)
gitCredentialsId = 'devopsGit'
gitURL = env.GIT_URL
gitContextDir = env.GIT_CONTEXT_DIR
gitBranch = env.GIT_BRANCH
gitCommit = null

// Build requests and limits
buildCPURequest = '100m'
buildMemRequest = '1000Mi'
buildCPULimit = '300m'
buildMemLimit = '2000Mi'
buildWaitTime = "960"

// Deployment requests and limits and base livenessDelay, readinessDelay, and numReplicas
numReplicas = 1
livenessDelay = 480
readinessDelay = 70

deployCPURequest = '100m'
deployMemRequest = '1000Mi'
deployCPULimit = '500m'
deployMemLimit = '2000Mi'
deploymentWaitTime = numReplicas * livenessDelay * 2000 * 2

versionNumber = null

pipeline = null

node() {
        repoName = gitURL.replaceAll("\\.git", "").split("/")[-1]
        print "Git URL: ${gitURL}, Repository Name:: ${repoName}, microservice: ${microservice}"

        gitCheckout(workspace, gitURL, gitBranch, gitCredentialsId, repoName)

        pom = readMavenPom file: "${repoName}/pom.xml"
        versionNumber = pom.version
        print "POM Artifact Version:: ${versionNumber}"

        pipeline = load "${repoName}/infrastructure/jenkins/Jenkinsfile"
}

pipeline.main()

/**
 * Clones and checks out the given Git repository branch and commit
 *
 * @param String workspace     Path of the working directory to use
 * @param String url           URL of the Git repository
 * @param String credentialsId Id of the Git credentials to use (From the credentials plugin in Cloudbees)
 */
def gitCheckout(String workspace, String url, String branch, String credentialsId, String repository) {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "${credentialsId}",
                passwordVariable: 'pass', usernameVariable: 'user']]) {
                sh """
                        rm -rf ${repository}
                        git clone -b ${branch} ${url}
                """
        }
}