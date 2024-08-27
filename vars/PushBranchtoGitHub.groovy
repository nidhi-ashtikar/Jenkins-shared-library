def call ( {
    def branchName = "${params.instance_name}-terraform-plan-branch"
    withCredentials([usernamePassword(credentialsId: 'Github', usernameVariable: 'GITHUB_USER', passwordVariable: 'GITHUB_TOKEN')]) {
        sh """
        git push https://\${GITHUB_USER}:\${GITHUB_TOKEN}@github.com/nidhi-ashtikar/infra-tf-creation.git ${branchName}
        """
    }
})