# README

A Java Template Project support:

- [X] MAVEN Java Lib Template
- [] MAVEN JAVA UI Testing Template
- [] MAVEN Springboot Template
- [] Github Action
- [] Code Coverage
- [] statistics Analysis
- [] CI/CD Pipeline Support

## Java Project

In real dev activity, there are a few things included in daily workflow:

1. Unit Testing
2. Code Coverage
3. Test Report
4. Code statistics
5. Version Checker
6. jenkins pipeline
7. Docker files
8. K8S support 9 ......

This template project is to target to make setting project easier.

## CheckStyle

- [spotless]
- [checkstyle](https://github.com/checkstyle/checkstyle)
- [checkstyle-github](https://github.com/checkstyle)
- [google java format](https://github.com/google/google-java-format)
- [google-style-precommit-check](https://github.com/maltzj/google-style-precommit-hook)
- [google style format maven plugin](https://github.com/Cosium/git-code-format-maven-plugin)

with google check style setting, and maven command is ***mvn checkstyle:check***

```xml

<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-checkstyle-plugin</artifactId>
	<version>3.1.1</version>
	<configuration>
		<configLocation>google_checks.xml</configLocation>
		<encoding>UTF-8</encoding>
		<consoleOutput>true</consoleOutput>
		<failsOnError>true</failsOnError>
		<linkXRef>false</linkXRef>
	</configuration>
	<executions>
		<execution>
			<id>validate</id>
			<phase>validate</phase>
			<goals>
				<goal>check</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

## spotless check

- [spotless](https://github.com/diffplug/spotless/)

command for running spotless check:

```shell
mvn spotless:check
mvn spotless:apply
```

## JUNIT setup

## maven surefire plugin setup

- [maven-surefire](https://maven.apache.org/surefire/maven-surefire-plugin/index.html)

## Sonar: TODO

- [sonarqube](https://www.sonarqube.org/)
- [sonar source](https://www.sonarsource.com/)
- [sonar plugins marketplace](https://www.sonarplugins.com/)

## Unit Testing coverage

- [junit]()
- [testng]()

## Github CICD: TODO

- [Action](../github/workflows/build.yml)
- [dependablebot](../github/dependabot.yml)

## Gitlab-cicd

- [gitlab-cicd](https://docs.gitlab.com/ee/ci/yaml/README.html)

## Application Security Scanner

please refer,[gitlab-security scan](https://docs.gitlab.com/ee/user/application_security/security_dashboard/index.html)

## Gradle To Maven: TODO

reference: [gradle to maven](https://www.baeldung.com/gradle-build-to-maven-pom)


## Examples

- [Security & QA, by L1NNA Lab](https://github.com/CISC-CMPE-327)