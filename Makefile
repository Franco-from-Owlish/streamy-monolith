env: env/app.env env/dev.env env/docker.env env/postgres.env

env/dev.env:
	cp env/dev.sample.env $@ && just set_db_password

env/docker.env:
	cp env/docker.sample.env $@

env/postgres.env:
	cp env/postgres.sample.env $@

env/app.env:
	cp env/app.sample.env $@

clean:
	find ./env -type f -name "*.env" -not -name "*.sample.env" -delete