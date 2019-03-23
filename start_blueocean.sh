docker run -d --rm -p 8080:8080 -u root --privileged -v /Users/stadheim/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock -v blueocean:/var/jenkins_home jenkinsci/blueocean
