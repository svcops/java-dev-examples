FROM registry.cn-shanghai.aliyuncs.com/iproute/eclipse-temurin:17-jdk

LABEL org.opencontainers.image.authors="tech@intellij.io"

LABEL email="tech@intellij.io" \
      author="zhenjie zhu"

WORKDIR /opt/app

ADD dev-biz/build/libs/dev-biz-1.0.0-SNAPSHOT.jar dev-biz-1.0.0-SNAPSHOT.jar

EXPOSE 8080

CMD java $JAVA_OPTIONS -jar dev-biz-1.0.0-SNAPSHOT.jar
