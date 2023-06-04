pipeline {
    agent any

    environment {
        DB_URL="jdbc:mariadb://mariadb:3306/blueone"
        DB_USERNAME="root"
        DB_PASSWORD="${MARIADB_ROOT_PASSWORD}"
    }

    stages {

        stage('환경 설정 테스트') {
            steps {
                sh 'printenv | sort'
            }
        }

        stage('환경 변수 설정') {
            steps {
                echo "JDBC 연결 URL은 ${env.DB_URL}"
                echo "DB 사용자명는 ${env.DB_USERNAME}"
                echo "DB 비밀번호는 ${env.DB_PASSWORD}"
            }
        }

        stage('테스트') {
            steps {
                slackSend (
                    channel: '#jenkins-notification',
                    color:  '#30A2FF',
                    message: "테스트가 시작되었습니다.\n작업 이름: ${env.JOB_NAME} \n작업 번호: ${env.BUILD_NUMBER} \nURL: ${env.BUILD_URL}"
                )
                echo '테스트가 시작됩니다.'
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

    post {
        success {
            slackSend (
                channel: '#jenkins-notification',
                color:  '#6ECCAF',
                message: "작업이 성공적으로 수행되었습니다. \n작업 이름: ${env.JOB_NAME} \n작업 번호: ${env.BUILD_NUMBER} \nURL: ${env.BUILD_URL}"
            )
        }
        failure {
            slackSend (
                channel: '#jenkins-notification',
                color:  '#FF0060',
                message: "작업이 실패하였습니다. \n작업 이름: ${env.JOB_NAME} \n작업 번호: ${env.BUILD_NUMBER} \nURL: ${env.BUILD_URL}"
            )
        }
    }
}