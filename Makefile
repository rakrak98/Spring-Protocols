# Makefile


# Phony targets prevent conflicts with files of the same name
.PHONY: all up down logs test clean help

.DEFAULT_GOAL := help

up: ## 🚀 Start all services in detached mode and build the app image
	@echo "--- Starting Docker containers... ---"
	docker-compose up -d --build

down: ## ⏹️ Stop and remove all running services
	@echo "--- Stopping Docker containers... ---"
	docker-compose down

logs: ## 📜 View and follow the logs from all services
	@echo "--- Tailing logs... ---"
	docker-compose logs -f

test: ## 🎯 Run the Gatling performance test against the webapp
	@echo "--- Running performance test (TPS=$(TPS), Duration=$(DURATION)s)... ---"
	./mvnw -pl performance-test -f pom.xml gatling:test
	@echo "--- Performance test finished. Report is in performance-test/target/gatling ---"

clean: ## 🧹 Stop services and remove all associated data (volumes)
	@echo "--- Stopping containers and removing volumes... ---"
	docker-compose down -v

help: ## ℹ️ Show this help message
	@echo "Usage: make [target]"
	@echo ""
	@echo "Available targets:"
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-10s\033[0m %s\n", $$1, $$2}'