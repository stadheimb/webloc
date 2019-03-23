pipeline {
  agent {
    docker {
      image 'maven:3.6.0-jdk-11-slim'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn package'
      }
    }
  }
}