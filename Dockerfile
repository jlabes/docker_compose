FROM bellsoft/liberica-openjdk-alpine:21-cds AS builder

WORKDIR /build
COPY . .

ARG LIB_JAR=lib/mysql-connector-java-8.0.30.jar

RUN mkdir -p classes dependencies \
 && javac -cp $LIB_JAR -d classes Main.java \
 && cd dependencies && jar -xf ../$LIB_JAR && cd .. \
 && jar --create --file app.jar --main-class=Main -C classes . -C dependencies .

FROM bellsoft/liberica-openjre-alpine:21-cds

WORKDIR /app

COPY --from=builder /build/app.jar .

CMD ["java", "-jar", "app.jar"]