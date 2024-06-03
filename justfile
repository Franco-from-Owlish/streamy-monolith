set export
set shell := ["bash", "-c"]
set dotenv-filename := "env/dev.env"

DOCKER_COMPOSE := "docker compose --env-file env/dev.env --env-file env/docker.env"
GRADLEW := "./gradlew"

# Show all recipes in an unsorted list
default:
    @just --list --unsorted

run *ARGS:
    {{GRADLEW}} {{ARGS}}

# Docker compose: Start all services
start:
    {{DOCKER_COMPOSE}} up -d
# Docker compose: Stop all containers and remove local images
stop:
    {{DOCKER_COMPOSE}} down --rmi local --remove-orphans

## Migrations: Create migrations
#make-migrations *APPS:
#    {{DJANGO}} makemigrations {{APPS}}
## Migrations: Create migrations for specified apps
## Migrations: Run migrations
#migrate:
#    {{DJANGO}} migrate

# Tests: Run pytest
test *ARGS:
    {{GRADLEW}} clean test --info {{ARGS}}
# Tests: Run pytest with coverage
coverage:
    {{GRADLEW}} koverHtmlReport
# Linting
lint:
    {{GRADLEW}} lint

# Replace DB_PASSWORD in env/dev.env with random password
@set_db_password:
    #!/usr/bin/python3
    import fileinput, secrets, string

    db_password_env_name = 'DB_PASSWORD'
    alphabet = string.ascii_letters + string.digits
    password = ''.join(secrets.choice(alphabet) for i in range(16))

    for line in fileinput.input("env/dev.env", inplace=True):
        if line.startswith(db_password_env_name):
          print('{}={}'.format(db_password_env_name, password), end='\n')
        else:
          print(line, end='')

# Cleanup
nuke-db: stop
    docker volume rm paystashio-django_postgres-db
