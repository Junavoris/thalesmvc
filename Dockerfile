# Use the official Tomcat image as a base
FROM tomcat:9.0

# Copy the WAR file to the webapps directory of Tomcat
COPY target/thalesmvc-0.1.war /usr/local/tomcat/webapps/

# Expose the port on which Tomcat will run
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]