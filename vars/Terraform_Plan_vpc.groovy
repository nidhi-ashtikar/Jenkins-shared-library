def call () {
            // withEnv([
            //     "AWS_ACCESS_KEY_ID=${params.AWS_ACCESS_KEY_ID}",
            //     "AWS_SECRET_ACCESS_KEY=${params.AWS_SECRET_ACCESS_KEY}"
            // ]) {
                sh """
                terraform plan -out=${env.PLAN_FILE} \
                -var 'region=${params.region}' \
                -var 'vpc_name=${params.vpc_name}' \
                -var 'vpc_cidr_block=${params.vpc_cidr_block}' \
                -var 'additional_tags=${params.additional_tags}' \
                -var 'public-subnet-cidr-1=${params.public-subnet-cidr-1}' \
                -var 'public-subnet-cidr-2=${params.public-subnet-cidr-2}' \
                -var 'private-subnet-cidr-1=${params.private-subnet-cidr-1}' \
                -var 'private-subnet-cidr-2=${params.private-subnet-cidr-2}' | tee ${env.PLAN_OUTPUT_FILE}
                """
            
    
}

