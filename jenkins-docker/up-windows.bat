@echo off

REM ** Remove running Jenkins container **
docker rm -fv jenkinsdevsu

REM ** Build Docker image **
docker build -t jenkinsdevsu:v1 .

REM ** Run Docker container using credentials file and port 7777 **
docker run --env-file creds/credentials.txt -v /var/run/docker.sock:/var/run/docker.sock -d --name jenkinsdevsu -p 7777:8080 jenkinsdevsu:v1