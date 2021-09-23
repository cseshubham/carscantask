# carscantask
# Project :-Manage users in a system

# Operation(Back End Part) :-Create ,Read,Update And Delete-

#Tech Stack:- Spring-Boot-JPA-MySQL



### 1. You can clone it from github by running following command

```
  $ git clone https://github.com/cseshubham/carscantask.git
```

### 2. Import project into eclipse
```
  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location
```
### 3. Right click on project in eclipse and then Maven -> Update Projects 

### 4. Change DB  as per your need, It's based on MySQL, src/main/java/resources/application.properties

### 5. Update database credential and other configuration into application.properties available in src/main/java/resources


### 6. Right click on UsermanageApplication.java file and run as Java Application

## Once Sprint Boot Application will be started successfully then we 
can call following Endpoints by using POSTMAN or Any Rest Client

### 7. To get list of users call following endpoint with GET Request
		```
		  http://localhost:8080/userservice/user
		```
### 8.To Create New User use following url with `POST` Request
		```
		  http://localhost:8080/userservice/user
		```
		### set content type as in header as `application/json`
		### set request body as raw with JSON body
		```
		  {
			"fname": "samdeep",
			"lname": "patidar",
			"dob": "2002-09-20",
			"city": "Dewas",
			"mobileNumber": "1234567890"
		  }

		```
### 9.To get a particular user, use following url with `GET` request type in postman
		```
		  http://localhost:8080/userservice/user/<id>
		```
### 10.To update Book in database, use following url with `PUT` request type in postman
		```
			http://localhost:8080/userservice/user
		```
		### set content type as in header as `application/json`
		### set request body as raw with JSON body

		```
		 {	
			"id": 1,
			"fname": "samdeep",
			"lname": "surnamechange",
			"dob": "2002-09-20",
			"city": "Dewas",
			"mobileNumber": "1234567890"
		  }
		```
### 11.To delete a particular Book from database, use following url with `DELETE` request type in postman
		```
		  http://localhost:8080/userservice/user/<id>
		```

### Note - Replace '<id>' with actual id 
