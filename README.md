# Spring Boot Demo Project
This is a demo project using spring-boot and JPA to build a REST API to calculate sum, average, count, min,max of transactions done last minute.
## Prerequisites
- Maven
- Tomcat(Any server)
- DB
## Code Flow
This project follows the layered model with every layer fulfilling it's unique functionality.
API Call -> Controller -> DTO -> Service -> Persistence(Model,Repository) ->  Service -> DTO(DAO can also be used) -> Controller -> Result 
### Controller
This is the main entry point from where the api call endpoints are exposed and control is passed to the application and result is passed through this. This layer uses the service bean to process the data. @RestController annotation is used for REST APIs. @Controller annotation can also be used for controller.
### DTO(Data Transfer Object)
DTOs are the wrapper objects that are used to wrap the object in our required format from call to backend and vice-versa.
### Service
This layer holds the major business logic of the application. All the processing and communication with the DB is done through this layer. This layer uses the DB repository beans to access the DB functionality. This layer takes the input in DTO format, processes it, uses CRUD operations through repository or can directly access the entity objects and return the objects in DTO or DAO format. @Service annotation is used for service bean.
### Persistence
This is further divided into 2 parts :
- model
- repository
* model - Contains the entity models of the database. @Entity annotation is used to define the class as an entity.
* repository - Contains the JPA methods to perform operations on DB. @Repository annotation is used define the class to be used as Repository.
### application.properties
This properties file is present in the resources folder and is used to provide the configuration settings for the application like DB configuration.
## Run the Project
Follow these steps To run this application on your system.
1. Clone the project on your system
2. Configure the application.properties file(present in resources folder) according to your DB.
3. Run the mvn clean install command.
4. Call the API http://localhost:8080/rest/transaction to make a transaction [POST]
5. Call the API http://localhost:8080/rest/statistics to get the statistics of the transaction
### DB name
spring.datasource.url = jdbc:mysql://localhost:3306/demo_app (In this case demo_app db is used)
### DB username
spring.datasource.username = root 
### DB Password
spring.datasource.password = 1234
