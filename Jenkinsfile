pipeline {
    agent any

    stages {
        stage('브랜치 확인') {
            steps {
                echo '브랜치 이름은 ' + env.BRANCH_NAME + '입니다.'
            }
        }

        stage('빌드') {
            steps {
                echo '빌드 중..'
            }
        }

        stage('테스트') {
            steps {
                echo '테스트 중...'
            }
        }

        stage('배포') {
            steps {
                echo '배포 중...'
            }
        }

    }
}