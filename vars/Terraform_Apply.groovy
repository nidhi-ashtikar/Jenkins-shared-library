def call (){
    sh """
        terraform apply -auto-approve ${env.PLAN_FILE}
        """
}