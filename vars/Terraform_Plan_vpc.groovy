// def call () {
//             // withEnv([
//             //     "AWS_ACCESS_KEY_ID=${params.AWS_ACCESS_KEY_ID}",
//             //     "AWS_SECRET_ACCESS_KEY=${params.AWS_SECRET_ACCESS_KEY}"
//             // ]) {
//                 sh """
//                 terraform plan -out=${env.PLAN_FILE} \
//                 -var 'region=${params.region}' \
//                 -var 'vpc_name=${params.vpc_name}' \
//                 -var 'vpc_cidr_block=${params.vpc_cidr_block}' \
//                 -var 'additional_tags=${params.additional_tags}' \
//                 -var 'public-subnet-cidr-1=${params.public-subnet-cidr-1}' \
//                 -var 'public-subnet-cidr-2=${params.public-subnet-cidr-2}' \
//                 -var 'private-subnet-cidr-1=${params.private-subnet-cidr-1}' \
//                 -var 'private-subnet-cidr-2=${params.private-subnet-cidr-2}' | tee ${env.PLAN_OUTPUT_FILE}
//                 """
            
    
// }


def call() {
    // Ensure parameters are correctly passed
    def region = params.region
    def vpcName = params.vpc_name
    def vpcCidrBlock = params.vpc_cidr_block
    def additionalTags = params.additional_tags
    def publicSubnetCidr1 = params.public-subnet-cidr-1
    def publicSubnetCidr2 = params.public-subnet-cidr-2
    def privateSubnetCidr1 = params.private-subnet-cidr-1
    def privateSubnetCidr2 = params.private-subnet-cidr-2

    echo "AWS_ACCESS_KEY_ID=${params.AWS_ACCESS_KEY_ID}"
    echo "AWS_SECRET_ACCESS_KEY=${params.AWS_SECRET_ACCESS_KEY}"
    echo "region=${region}"
    echo "vpc_name=${vpcName}"
    echo "vpc_cidr_block=${vpcCidrBlock}"
    echo "additional_tags=${additionalTags}"
    echo "public-subnet-cidr-1=${publicSubnetCidr1}"
    echo "public-subnet-cidr-2=${publicSubnetCidr2}"
    echo "private-subnet-cidr-1=${privateSubnetCidr1}"
    echo "private-subnet-cidr-2=${privateSubnetCidr2}"

    withEnv([
        "AWS_ACCESS_KEY_ID=${params.AWS_ACCESS_KEY_ID}",
        "AWS_SECRET_ACCESS_KEY=${params.AWS_SECRET_ACCESS_KEY}"
    ]) {
        sh """
        terraform plan -out=${env.PLAN_FILE} \
        -var 'region=${region}' \
        -var 'vpc_name=${vpcName}' \
        -var 'vpc_cidr_block=${vpcCidrBlock}' \
        -var 'additional_tags=${additionalTags}' \
        -var 'public-subnet-cidr-1=${publicSubnetCidr1}' \
        -var 'public-subnet-cidr-2=${publicSubnetCidr2}' \
        -var 'private-subnet-cidr-1=${privateSubnetCidr1}' \
        -var 'private-subnet-cidr-2=${privateSubnetCidr2}' | tee ${env.PLAN_OUTPUT_FILE}
        """
    }
}
