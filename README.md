# Student-management-System
<li>I have developed this REST API for a Student-management-System. This API performs
  all the fundamental CRUD operations of Student Management with Owner validation at every step.</li>

![Student Er Diagram](https://user-images.githubusercontent.com/101594693/209407645-66f5305e-d579-459a-be8d-cf455e162ae5.png)

# Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Maven

# Modules

- Login Module
- Owner Module
- Student Module
- Courses Module
- Address Module

# Features

- Data Authentication and Validation for all the users (Student, Owner)

## Owner Features
- Owner can login by giving valid credentials.
- Owner can add Students and provide the courses. 
- Owner can add the courses.
- Owner can get student by name.
- Owner can get students assigned to a particular course.


## Student Features
- Student can update their details.
- Student can leave the course.
- Can search for topic he assign.


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, ownername and password as per your local database configuration.

```
    server.port=8880

    spring.datasource.url=jdbc:mysql://localhost:8880/foodplaza1;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8880/
```
```
http://localhost:8880/swagger-ui/#/
```
# API Reference



# Sample API Response for Owner Account Creation
### Request Type
```
POST
```

### Request URI
```
http://localhost:8880/owner/
```

### Request Body
```
{
    "name":"Om Mishra",
   "email":"omanubhav@gmail.com",
   "password":"anubhav123"
}
```
### Response Body

```
{
  "id": 2,
    "name": "Om Mishra",
    "email": "omanubhav@gmail.com",
    "password": "anubhav123"
}
```
# Sample API Response for Student Account Creation
### Request Type
```
POST
```

### Request URI
```
http://localhost:8880/owner/student
```

### Request Body
```
{
    "name":"Anubhav",
    "dateOfBirth":"2002-09-18",
    "gender":"male",
    "email":"omanubhavmishra@gmail.com",
    "password":"omanubhav123",
    "mobileNumber":"8957107552",
    "parentsName":"Anupam Mishra"
}
```
### Response Body

```
{
  "student_id": 2,
    "name": "Anubhav",
    "mobileNumber": "8957107552",
    "email": "omanubhavmishra@gmail.com",
    "password": "omanubhav123",
    "dateOfBirth": "2002-09-18T00:00:00.000+00:00",
    "gender": "male",
    "parentsName": "Anupam Mishra"
}
```
# Thanks For Taking Time
