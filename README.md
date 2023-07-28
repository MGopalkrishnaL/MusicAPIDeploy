# MusicAPIDeploy
### Requirements
* IntelliJIDEA
* ServerPort: 8080 (use: localhost:8080)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)
* AWS(EC2) 
### Steps to run the Project
* Download the source code and import in intellijIDEA.
* Go to localhost:8080/
* Put specific end_points besides the port accordingly to run the project to access and modify the data
or
*Click on the link which is integrated with swagger and use it
```http://13.48.178.234:8080/swagger-ui/index.html#/
```
# Dependencies
## Validation
* Bean Validation with Hibernate validator.
## Spring Web
* Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
## Spring Boot DevTools
* Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
## Spring Data JPA
* Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
## Lombok
* Java annotation library which helps to reduce boilerplate code.
## MySQL
* MySQL JDBC driver.
## Swagger
* It provide the UserInterface for all our API's. 
# Project Structure(MVC Structure)
## Model
* Music Model
* Client Model

## Controller
* ClientController
## DAO
* MusicRepository
* ClientRepository

## Service
* MusicService
* ClientService

# EndPoints

## Client
  * updateTheSong
  * showPlayListOfUser
  * CreateClietWithAdminPrevialges
  * SaveClient
  * CrudToPlayList
  * AddTheSong
  * getAllSongs
  * deleteThesong
# Working
* Project mainly focuses on Music and Client.
* Crud operations on client like add user,fetch user,validateTheRole.
* We have provide the validations on every entry data from the end user. 
* All the can be seen in the mySql workbench
* we have deployed our project by using Static Url of the AWS Server which helps in running the project in background.
