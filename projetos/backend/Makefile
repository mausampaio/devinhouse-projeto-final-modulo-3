ifeq (run, $(firstword $(MAKECMDGOALS)))
  runargs := $(wordlist 2, $(words $(MAKECMDGOALS)), $(MAKECMDGOALS))
  $(eval $(runargs):;@true)
endif

down:
	docker-compose down
package:  down
	mvn clean package -Dmaven.test.skip=true $(quiet)
run: package
	docker-compose up $(runargs)