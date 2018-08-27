// Declare the Application Id
slave = env.JENKINS_OS

// GIT Url of application to build and deploy on Openshift
gitURL = env.GIT_URL

def jenkinsFile
stage('Loading Jenkins file') {
	repoName = gitURL.replaceAll("\\.git", "").split("/")[-1]
	jenkinsFile = load "${repoName}/cicd/jenkins/${slave}/Jenkinsfile"
}

jenkinsFile.start()
