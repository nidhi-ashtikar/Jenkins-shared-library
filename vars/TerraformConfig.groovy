
def setEnvironmentAndParams() {
    pipeline {
        environment {
            GITHUB_CREDENTIALS = credentials('Github')
            GIT_USER_NAME = "nidhi-ashtikar"
            GIT_USER_EMAIL = "ashtikarnidhi19@gmail.com"
            PLAN_FILE = "terraform-plan.out"
            PLAN_OUTPUT_FILE = "terraform-plan.txt"
        }

        parameters {
            string(name: 'AWS_ACCESS_KEY_ID', defaultValue: '', description: 'Enter AWS Access Key ID')
            password(name: 'AWS_SECRET_ACCESS_KEY', defaultValue: '', description: 'Enter AWS Secret Access Key')
            string(name: 'instance_name', defaultValue: 'my-instance', description: 'EC2 Instance Name')
            string(name: 'instance_type', defaultValue: 't2.micro', description: 'EC2 Instance Type')
            choice(choices: ['us-east-2', 'us-east-1', 'us-west-1'], description: 'Select in which region you want to deploy the resource', name: 'region')
        }
    }
}
