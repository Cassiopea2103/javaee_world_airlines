FROM tomcat:latest

# straight deploying the war file into the tomcat server
COPY target/*.war /usr/local/tomcat/webapps/