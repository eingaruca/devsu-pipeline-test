FROM jenkins/jenkins:2.394-alpine

############# Change root to jenkins user ##########################
USER root
# Configure Jenkins to run as the `jenkins` user
ENV  JAVA_OPTS -Djenkins.install.runSetupWizard=false
# Update the package list and install git
RUN  apk update & apk add git

# Copy the plugins file and install the plugins
RUN chown -R jenkins:jenkins /var/jenkins_home/
COPY --chown=jenkins:jenkins plugins/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN  jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

# Configure Jenkins to use configuration as code (CASC)
ENV  CASC_JENKINS_CONFIG /casc.yaml
COPY --chown=jenkins:jenkins casc/casc.yaml /casc.yaml
RUN apk add --update docker openrc
RUN rc-update add docker boot
RUN apk add terraform