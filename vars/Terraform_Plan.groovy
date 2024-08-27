def call () {
            withEnv([
                "AWS_ACCESS_KEY_ID=${params.AWS_ACCESS_KEY_ID}",
                "AWS_SECRET_ACCESS_KEY=${params.AWS_SECRET_ACCESS_KEY}"
            ]) {
                sh """
                terraform plan -out=${env.PLAN_FILE} \
                -var 'region=${params.region}' \
                -var 'instance_name=${params.instance_name}' \
                -var 'instance_type=${params.instance_type}' | tee ${env.PLAN_OUTPUT_FILE}
                """
            }
    
}

