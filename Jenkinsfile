// Declare the script type of OS on which Jenkins Running i.e. bat or shell
scriptType = env.JENKINS_OS_SCRIPT_TYPE

// Declare the Application Id
applicationId = env.APP_ID

// Declare application name
application = env.APP_NAME

// Declare application type java or dot-net
applicationType = env.APP_TYPE

// Declare microservice name
microservice = env.MICROSERVICE_NAME

// Collect the git info (Since the git plugin has trouble providing the URL and commit hash)
gitCredentialsId = 'devopsGit'
gitURL = env.GIT_URL
gitContextDir = env.GIT_CONTEXT_DIR
gitBranch = env.GIT_BRANCH
gitCommit = null

// Pull in default Jenkinsfile
masterJenkinsfileGitURL = env.CICD_GIT_URL
masterJenkinsfileGitBranch = env.CICD_GIT_BRANCH

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

def jenkinsFile
stage('Loading Jenkins file') {
	repoName = gitURL.replaceAll("\\.git", "").split("/")[-1]
	jenkinsFile = load "${repoName}/cicd/jenkins/${scriptType}/Jenkinsfile"
}

jenkinsFile.start()
