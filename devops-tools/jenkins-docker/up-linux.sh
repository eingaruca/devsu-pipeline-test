
# ** Remove running Jenkins container **
sudo docker rm -fv jenkinsdevsu

# ** Build Docker image **
sudo docker build -t jenkinsdevsu:v1 .

# ** Run Docker container using credentials file and port 7777 **
sudo docker run --env-file creds/credentials.txt -v /var/run/docker.sock:/var/run/docker.sock -d --name jenkinsdevsu -p 7777:8080 jenkinsdevsu:v1
