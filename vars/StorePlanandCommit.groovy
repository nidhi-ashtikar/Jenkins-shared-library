def call () {
    if (fileExists(env.PLAN_OUTPUT_FILE)) {
        sh """
        git add ${env.PLAN_FILE} ${env.PLAN_OUTPUT_FILE}
        git commit -m "Add Terraform plan output"
        """
    } else {
        error "Terraform plan output file not found!"
    }
}