FROM jenkins/jenkins:2.375.1-jdk11

USER root
RUN curl -sSL https://get.docker.com/ | sh
RUN groupadd -g 999 docker
RUN useradd -r -u 1000 -g docker jenkins
USER jenkins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

COPY seedJob.xml /usr/share/jenkins/ref/jobs/seed-job/config.xml

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false