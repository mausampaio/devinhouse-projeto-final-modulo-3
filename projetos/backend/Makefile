docker-compose down:
	docker-compose down
maven-package:  docker-compose down
	mvn clean package -Dmaven.test.skip=true
run: maven-package
	docker-compose up