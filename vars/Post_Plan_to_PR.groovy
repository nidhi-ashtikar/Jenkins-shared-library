def call () {
    def branchName = "${params.resource_name}-terraform-plan-branch"
        withCredentials([usernamePassword(credentialsId: 'Github', usernameVariable: 'GITHUB_USER', passwordVariable: 'GITHUB_TOKEN')]) {
            sh """
            gh pr create --repo https://github.com/nidhi-ashtikar/infra-tf-creation.git --head ${branchName} --title "Terraform Plan" --body "\$(cat ${env.PLAN_OUTPUT_FILE})"
            """
        }
}