FROM adoptopenjdk/openjdk8:latest
ENV JAVA_OPTS="-XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=92 \
-XX:+CMSParallelInitialMarkEnabled -XX:+CMSScavengeBeforeRemark \
-Xloggc:/app/gc.log -XX:+DisableExplicitGC -XX:+PrintGCDetails \
-XX:+PrintGCDateStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M \
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/app/appoom"
VOLUME /tmp
ADD happy-code-initializr.jar app.jar
ENTRYPOINT ["sh","-c","java ${JAVA_OPTS} -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -jar app.jar"]