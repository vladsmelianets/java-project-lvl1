clean:
	.\gradlew clean

build:
	.\gradlew clean build

install:
	.\gradlew clean install

run:
	.\gradlew run

lint:
	.\gradlew checkstyleMain checkstyleTest

update-deps:
	.\gradlew useLatestVersions

run-dist:
	.\build\install\app\bin\app

build-run: build run

install-run: install run-dist