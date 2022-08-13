# Serenity JUnit/BDD cucumber project

Get started quickly with Serenity BDD and JUnit 5 with this simple starter project. 

## Get the code

Click on the [Use This Link](https://github.com/<name>/<project>.git) create a new repository in your Git. 

Or simply [download a zip](https://github.com/<name>/<project>/archive/master.zip) file.

## Use Gradle

For gradle, use a command window and run:

    gradlew test

## Running the tests under Maven

The template project comes with both Maven and Gradle build scripts. To run the tests with Maven, open a command window and run:

    mvn clean verify

*NOTE*: If you get following error - Fatal error compiling: error: invalid target release: 16 -> [Help 1]
	The Maven may be using a different Java version to compile the project, and you can use mvn -version to find out the Maven details.
	Update the pom.xml section for maven-compiler-plugin and set the correct version as per your Maven details.
	
## Tests

There are runners for both Junit and Cucumber, you only need one you can comment the other file. Both run same tests. 

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!
