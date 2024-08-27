def call () {
    def branchName = "${params.instance_name}-terraform-plan-branch"
    sh """
    git config user.name "${env.GIT_USER_NAME}"
    git config user.email "${env.GIT_USER_EMAIL}"
    git checkout -b ${branchName} || echo "Branch ${branchName} already exists, skipping branch creation."
    """
}