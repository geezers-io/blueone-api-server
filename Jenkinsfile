def defaultSlackChannel = '#jenkins-notification'

def START = '#30A2FF'
def SUCCESS = '#6ECCAF'
def FAILED = '#FF0060'

def notifyStageStart(stageName, workNumber, url) {
  print("${stageName} 시작에 대해 슬랙 메시지를 발행합니다.")
  def message = """
        [${stageName}] 단계가 시작되었~~쥬? 터질 지 성공할 지는 아무도 장담 못하~~~~쥬???ㅋㅋㅋ 😘😘
        굳이 알려주기 싫지만, 작업 번호는 ${workNumber},
        작업 내역 상세하게 보고 싶으면 ㅋㅋㅋㅋ 굳이 이걸??? 싶지만 ㅋㅋㅋㅋ 😊😊
        ${url} 여기 ㅋㅋ 🤣🤣🤣🤣
    """
  slackSend(
    channel: defaultSlackChannel,
    color: START,
    message
  )
}

pipeline {
  agent any

  environment {
    DB_URL="${DB_URL}"
    DB_USERNAME="${DB_USERNAME}"
    DB_PASSWORD="${DB_PASSWORD}"
  }

  stages {

    stage('환경 설정 테스트') {
      steps {
        sh 'printenv | sort'
      }
    }

    stage('테스트') {
      steps {
        notifyStageStart(env.STAGE_NAME, env.BUILD_NUMBER, env.BUILD_URL)
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

