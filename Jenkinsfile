def notifyStageStart(stageName, workNumber, url, branchName) {
  def START = '#30A2FF'
  def defaultSlackChannel = '#jenkins-notification'
  print("${stageName} 시작에 대해 슬랙 메시지를 발행합니다.")
  def message = """
*"${stageName}"* 단계가 시작되었~~쥬? 터질 지 성공할 지는 아무도 장담 못하~~~~쥬???ㅋㅋ😘😘
굳이 알려주기 싫지만, 작업 번호는 *${workNumber}* 번(${branchName}),
작업 내역 상세하게 보고 싶으면 ㅋㅋㅋㅋ 굳이 이걸??? 싶지만 ㅋㅋㅋㅋ 😊😊
<${url}| *여기*> 🤣🤣🤣🤣
    """
  slackSend(
    channel: defaultSlackChannel,
    color: START,
    message: message
  )
}

def notifySuccess(stageName, workNumber, url, branchName) {
  def defaultSlackChannel = '#jenkins-notification'
  def SUCCESS = '#6ECCAF'
  def message = ''
  if (stageName == '빌드') {
    message = """
*${workNumber}* 번(${branchName}}) ${stageName} 단계는 아직 구현중이긴한데 일단 성공했엉~ 너 짱;; 👍
추 후 도커 이미지로 자동화 배포를 구현할 예정이예양~~😒 <${url}|open>
"""
  } else if (stageName == '테스트') {
    message = """
*${workNumber}* 번(${branchName}) ${stageName} 테스트에 성공했음~~ 코드 좀 치네 😉😉 <${url}|open>
"""
  } else {
    message = "*${workNumber}* 번(${branchName}) 작업에 성공했음! <${url}|open>"
  }
  slackSend(
    channel: defaultSlackChannel,
    color: SUCCESS,
    message: message
  )
}

def notifyBuildFailure(stageName, workNumber, url) {
  def FAILED = '#FF0060'
  def defaultSlackChannel = '#jenkins-notification'

}

def notifyBuildAborted(stageName, workNumber, url) {
  def defaultSlackChannel = '#jenkins-notification'

}

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
        notifyStageStart(env.STAGE_NAME, env.BUILD_NUMBER, env.BUILD_URL, env.BRANCH_NAME)
        sh 'printenv | sort'
      }
    }

    stage('테스트') {
      steps {
        notifyStageStart(env.STAGE_NAME, env.BUILD_NUMBER, env.BUILD_URL, env.BRANCH_NAME)
        echo '테스트가 시작됩니다.'
        sh './gradlew test'
      }
    }

    stage('빌드') {
      steps {
        notifyStageStart(env.STAGE_NAME, env.BUILD_NUMBER, env.BUILD_URL, env.BRANCH_NAME)
        sh './gradlew clean bootJar'
      }
    }

    stage('배포') {
      steps {
        notifyStageStart(env.STAGE_NAME, env.BUILD_NUMBER, env.BUILD_URL, env.BRANCH_NAME)
        echo '배포 중...'
      }
    }

  }

  post {
    success {
      notifySuccess(env.STAGE_NAME, env.BUILD_NUMBER, env.BUILD_URL, env.BRANCH_NAME)
    }

    aborted {
      print('공사 중')
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

