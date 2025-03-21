Animal Management CRUD API 

Description
A simple CRUD API for managing animal objects using Spring Boot, JPA, and MYSQL.

Installation
1. Clone the repository or download the zip file.
2. This project runs with JDK 21.
3. Database Configuration: There should be an animals database created before running the code. The animals table should be able to automatically load.
4. At the end I have added in pictures as well. 

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

![Screenshot 2025-03-21 at 12 28 26 AM](https://github.com/user-attachments/assets/b1289ac4-ee23-4f81-81f9-9d5f75d205dc)



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

![Screenshot 2025-03-21 at 12 34 49 AM](https://github.com/user-attachments/assets/6bda36ae-9d00-4648-a9c6-ee8550f2a2cd)


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

![Screenshot 2025-03-21 at 12 35 19 AM](https://github.com/user-attachments/assets/2fde238d-dbd2-4058-be7c-139673670d69)

  
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

 ![Screenshot 2025-03-21 at 12 36 05 AM](https://github.com/user-attachments/assets/6a6f8528-e94f-485c-bc8e-c133bbc3be6c)

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
![Screenshot 2025-03-21 at 12 31 22 AM](https://github.com/user-attachments/assets/35cc98df-2546-4aa1-a1a9-8884f9a60d01)
![Screenshot 2025-03-21 at 12 33 04 AM](https://github.com/user-attachments/assets/5db19824-7e9f-4c45-8b8b-b0bff17137f0)

Response: The newly created Animal Object:
{
  "animalId": 3,
  "name": "Timon",
  "category": "Meerkat",
  "age": 3,
  "description": "A funny and witty meerkat."
}

![Screenshot 2025-03-21 at 12 33 28 AM](https://github.com/user-attachments/assets/0c9c9e14-2af1-4cc5-9111-fb22caf49371)


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
![Screenshot 2025-03-21 at 12 37 20 AM](https://github.com/user-attachments/assets/300e0f30-2c44-43c5-b5df-5da4cae44975)

Response - The update Animal Object: 
{
  "animalId": 1,
  "name": " Simba",
  "category": "Lion",
  "age": 6,
  "description": "King of the Pride Lands."
}
![Screenshot 2025-03-21 at 12 37 44 AM](https://github.com/user-attachments/assets/21430fde-c195-40cc-8eac-944f42b00258)

Delete an Animal

DELETE /delete/{animalId}

Deletes an exisiting animal. 

Example Request: DELETE http://localhost:8080/animals/delete/3

Response - Message:  {"message": "Animal deleted successfully."} 

Picture of my database. 
![Screenshot 2025-03-21 at 12 40 06 AM](https://github.com/user-attachments/assets/714d9b22-bfbe-4f40-8b3d-6637002197de)

