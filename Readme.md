# VolunteerHUB
VolunteerHUB is pet-project of Yaraslau Dubovik.

VolunteerHUB is portal that connects volunteers and customers, helps to find activities for volunteers and volunteers for customers.

Current version - 0.4.0

## Technology Stack

- Java 17 
- Spring Boot 3.3.0
- Apache Derby Server DB 10.15.2.0
- HQL
- Thymeleaf
- Maven

## Build and Run application

- Run next maven command to build application:
```maven
mvn clean package
```

- Use any servlet container or server to run build application "war" file. This file located by next path:
```
[PROJECT_HOME]\targer\*.war
```

## Dependencies

You need to install and run Apache Derby Server Database according to volunteer-hub-db project:

https://github.com/Yaraslau/volunteer-hub-db

## Versions

- 0.1.0 - Spring Core Application with limited functionality
- 0.2.0 - Spring JDBC Application with limited functionality
- 0.2.1 - Spring + Hibernate Application with limited functionality
- 0.2.2 - Spring Data JPA (Hibernate as JPA Vendor Adapter) Application with limited functionality
- 0.3.0 - Spring MVC + Spring Data JPA (Hibernate as JPA Vendor Adapter) Application with limited functionality
- 0.4.0 - Spring Boot Application with limited functionality

## Current Features

Guest user:

- can see all events
- can see all activities of selected event

## Author

Yaraslau Dubovik

Senior Software Engineer

www.linkedin.com/in/yaraslaudubovik

## License

- It is prohibited to use the source code or its modifications for commercial purposes
- It is permitted to use the source code and its modifications for non-commercial purposes only with the consent of the author