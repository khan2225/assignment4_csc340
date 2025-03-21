Animal Management CRUD API 

Description
A simple CRUD API for managing animal objects using Spring Boot, JPA, and MYSQL.

Installation
1. Clone the repository or download the zip file.
2. This project runs with JDK 21.
3. Database Configuration: There should be an animals database created before running the code. The animals table should be able to automatically load.

API Endpoints

Base URL: http://localhost:8080/animals

Get all animals

GET /all

Returns a list of all animals in the database. 

Response - A JSON array of Animal Objects:

[
  {
    "name": "Simba",
    "category": "Lion",
    "age": 5,
    "description": "A brave lion from the Pride Lands."
  },
  {
    "name": "Sarabi",
    "category": "Lioness",
    "age": 8,
    "description": "The Queen of the Pride Lands."
  }
]


GET animal by id 

GET /{animalId}

Fetches an individual animal by ID.

Example Request: GET http://localhost:8080/animals/1

Response: A single JSON Animal Object. 

[
{
  "animalId": 1,
  "name": "Simba",
  "category": "Lion",
  "age": 5,
  "description": "A brave lion from the Pride Lands."
}
]

Get animals by category

GET /category/{category}

Fetches a list of animals within given category. 

Example Request: GET http://localhost:8080/animals/category/Lion

Response: A JSON array of Animal Objects: 

[
  {
    "animalId": 1,
    "name": "Simba",
    "category": "Lion",
    "age": 5,
    "description": "A brave lion from the Pride Lands."
  }
]  
  
Search animals by name 

GET /search?name=Simba

Fetches animals whose name contains the given string. 

Example Request: GET http://localhost:8080/animals/search?name=Simba

[
  {
    "animalId": 1,
    "name": "Simba",
    "category": "Lion",
    "age": 5,
    "description": "A brave lion from the Pride Lands."
  }
]

Create New Animal

POST /new

Creates a new animal entry. 

Example Request Body: 

{
  "name": "Timon",
  "category": "Meerkat",
  "age": 3,
  "description": "A funny and witty meerkat."
}

Response: The newly created Animal Object:
{
  "animalId": 3,
  "name": "Timon",
  "category": "Meerkat",
  "age": 3,
  "description": "A funny and witty meerkat."
}

Update an Exisiting Animal

POST /update/{animalId}

Updates an exisiting animal. 

Example Request: POST http://localhost:8080/animals/update/1

{
  "name": "Simba",
  "category": "Lion",
  "age": 6,
  "description": "King of the Pride Lands."
}

Response - The update Animal Object: 
{
  "animalId": 1,
  "name": " Simba",
  "category": "Lion",
  "age": 6,
  "description": "King of the Pride Lands."
}

Delete an Animal

DELETE /delete/{animalId}

Deletes an exisiting animal. 

Example Request: DELETE http://localhost:8080/animals/delete/3

Response - Message:  {"message": "Animal deleted successfully."} 
