def call () {
    sh """
                        terraform init -upgrade
                        terraform providers lock 
                        """
}