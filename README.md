# InterviewCalendarAPI
Application to schedule interviews

	
## Project Structure
- **Config** - Package with configuration Files
- **Model** - Package with classes that represent data model objects and their relationships
- **Controller** - Package with classes responsible for receiving and dispatching requests to Endpoints
- **Service** - Package with the classes responsible for the application logic. Maps incoming requests from the controller to the repository
- **Repository** - Package with classes that access the database
- **Exception** - Package with classes responsible for launching customized exceptions in the application

	
## Database 

The database is filled when launching the application with some false data

Was used [H2](https://www.h2database.com/html/main.html)

It can be accessed through:
[Application Database](http://localhost:8080/h2)


## Documentation

The documentation contains the list of API endpoints and more information about the application

Was used [Swagger](https://swagger.io/)

It can be accessed through:
[Application Documentation](http://localhost:8080/swagger-ui/)


## Software Tests
Was used [JUnit](https://junit.org/junit5/) and [Mockito](https://site.mockito.org/)