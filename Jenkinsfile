node ( 'linux'){
  stage 'Build and Test'
  env.PATH = "${tool 'Ant'}/bin:${env.PATH}"
  checkout scm
  sh 'ant build'
  }