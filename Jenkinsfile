pipeline {
    agent any

    environment {
        DB_URL='jdbc:mariadb://mariadb:3306/blueone'
        DB_USERNAME='root'
        DB_PASSWORD=System.getenv('MARIADB_ROOT_PASSWORD')
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