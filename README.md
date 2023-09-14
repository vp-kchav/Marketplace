This is a simple, bare-bones service that will be used as the basis as the back end for your craft demonstration.

## Installing the project

### Requirements
- [Java11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
- [Maven](https://maven.apache.org/download.cgi)


### Steps to install

1. Once you have the prerequisite libraries installed, navigate to the location you would like to clone this repository to on your machine's command line.
1. `git clone git@github.intuit.com:poolhiring/marketplace-backend-springboot.git`.
1. Navigate into the newly-created `marketplace-backend-springboot` directory.
1. `mvn -N wrapper:wrapper`
1. `mvn clean install` 

Great job! Now you should be all set to run the project!

## Running the project

In the project directory, you need only to run `./mvnw spring-boot:run -f "pom.xml"`. This will start a server at [http://localhost:8080](http://localhost:8080).
You can visit [http://localhost:8080/helloworld](http://localhost:8080/helloworld) to see the example service.

To stop the project, kill the process using Ctrl-C.

## Using an IDE

Now that you have the project running from the command line, you can also import the project to the IDE of your choice to make working with it easier.
Some possibilities are:
- [Spring Tool Suite](https://spring.io/tools)
- [Eclipse](https://www.eclipse.org/downloads/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Visual Studio](https://visualstudio.microsoft.com/)

## About the project

The project was created using the [spring initializr](https://start.spring.io/).
Learn about [spring boot](https://spring.io/projects/spring-boot).

## In Memory Database

The project comes with an H2 in-memory database configured in application.properties. The H2 console is at [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/), and it can be connected to using `jdbc:h2:mem:marketplacedb` as the database url.
