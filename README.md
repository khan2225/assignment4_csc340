#Animal Management CRUD API 

##Description
A simple CRUD API for managing animal objects using Spring Boot, JPA, and MYSQL.

##Installation
1. **Clone the repository or download the zip file.
2. This project runs with JDK 21.
3. Database Configuration: There should be an animals database created before running the code. The animals table should be able to automatically load.

API Endpoints

Base URL: http://localhost:8080/animals

GET all animals
GET /all
returns a list of all animals in the database. 

GET animal by id 
GET /{animalId}
Fetches an individual animal by ID.

Get animals by category
GET /category/{category}
fetches a list of animals within given category. 

Search animals by name 
GET /search?name=Simba
Fetches animals whose name contains the given string. 

Create New Animal
POST /new
Creates a new animal entry. 

Update an Exisiting Animal
POST /update/{animalId}
Updates an exisiting animal. 

Delete an Animal
DELETE /delete/{animalId}
Deletes an exisiting animal. 
