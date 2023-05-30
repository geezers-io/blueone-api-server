pipeline {
    agent any

    stages {

        stage('테스트') {
            steps {
                sh './gradlew test'
            }
        }

        stage('빌드') {
            steps {
                sh './gradlew clean bootJar'
            }
        }



        stage('배포') {
            steps {
                echo '배포 중...'
            }
        }

    }
}