def call () {
    withEnv([
        "AWS_ACCESS_KEY_ID=${params.AWS_ACCESS_KEY_ID}",
        "AWS_SECRET_ACCESS_KEY=${params.AWS_SECRET_ACCESS_KEY}"
    ]) {
        sh 'terraform init'
    }
}

