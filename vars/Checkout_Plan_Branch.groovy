def call (){
    withCredentials([usernamePassword(credentialsId: 'Github', usernameVariable: 'GITHUB_USER', passwordVariable: 'GITHUB_TOKEN')]) {
                    git branch: "${params.PLAN_BRANCH}", url: 'https://github.com/nidhi-ashtikar/infra-tf-creation.git'
                }
}