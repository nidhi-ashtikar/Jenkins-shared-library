def call () {
             {
                sh """
                terraform plan -out=${env.PLAN_FILE} \
                -var 'region=${params.region}' \
                -var 'cidr_block_vpc=${params.cidr_block_vpc}' \
                -var 'cidr_block_public_subnet1=${params.cidr_block_public_subnet1}' \
                -var 'cidr_block_public_subnet2=${params.cidr_block_public_subnet2}' | tee ${env.PLAN_OUTPUT_FILE}
                """
            
    
}


