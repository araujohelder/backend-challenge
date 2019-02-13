FROM openjdk:8u181-jdk-alpine3.8

LABEL maintainer="helder.araujo@cipa.com.br"

ENV LANG C.UTF-8

RUN apk add --update bash

ADD target/*.jar /app/app.jar 

CMD java -jar /app/app.jar '--spring.datasource.url=jdbc:postgresql://invilliadb:5432/invillia'
                            