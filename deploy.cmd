set MAVEN_USER_HOME=D:\home\site\deployments\tools\maven
set MAVEN_OPTS=-Djava.net.preferIPv4Stack=true -Djava.net.preferIPv6Addresses=false
rm -f D:\home\site\wwwroot\webapps\ROOT.war
rm -rf D:\home\site\wwwroot\webapps\ROOT
mvnw -s .mvn\settings.xml clean package -Ddir=D:\home\site\wwwroot\webapps