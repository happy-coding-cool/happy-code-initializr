FROM adoptopenjdk/openjdk8:latest
ENV JAVA_OPTS="-XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=92 \
-XX:+CMSParallelInitialMarkEnabled -XX:+CMSScavengeBeforeRemark \
-XX:+DisableExplicitGC -XX:+PrintGCDetails -Xloggc:gc.log \
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/usr/local/appoom"
VOLUME /tmp
ADD happy-code-initializr.jar app.jar
ENTRYPOINT ["sh","-c","java ${JAVA_OPTS} -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
