# 📘 Student Management System – Spring Boot REST API

A simple and clean **Spring Boot CRUD API** for managing student information.  
This project demonstrates RESTful API design with Controller, Service, Repository layers, DTO usage, and proper HTTP responses.

---

## 🚀 Features

- ➕ Create a new student  
- 📄 Get all students  
- 🔍 Get a student by ID  
- ✏️ Update a student (PUT)  
- 🛠️ Partially update a student (PATCH)  
- ❌ Delete a student  

---

## 🧱 Tech Stack

- **Java 17+**  
- **Spring Boot**  
- **Spring Web**  
- **Spring Data JPA**  
- **Lombok**  
- **Maven**  
- **H2/MySQL** (based on configuration)

---

## 📦 Project Structure

```
com.example.student_management
│
├── controller          // REST Controllers
├── service             // Business logic
├── repository          // JPA Repository interfaces
├── dto                 // Request/Response DTOs
└── entities            // JPA Entities
```

---

## 🌐 API Endpoints

### ➤ Get All Students  
```
GET /student
```

### ➤ Get Student by ID  
```
GET /student/{id}
```

### ➤ Create New Student  
```
POST /student
```

#### Sample Request Body
```json
{
  "name": "John Doe",
  "age": 22,
  "email": "john@example.com"
}
```

### ➤ Delete Student
```
DELETE /student/del/{id}
```

### ➤ Update Student (PUT – Full Update)
```
PUT /student/update/{id}
```

#### Sample Request Body
```json
{
  "name": "Updated Name",
  "age": 23,
  "email": "updated@gmail.com"
}
```

### ➤ Partially Update Student
```
PATCH /student/update/{id}
```

#### Sample Request Body
```json
{
  "email": "newEmail@example.com"
}
```

---

## 🛠️ How to Run the Project

### 1️⃣ Clone the repository
```bash
git clone https://github.com/harshit36singh/Student_Management.git
```

### 2️⃣ Open the project
```bash
cd Student_Management
```

### 3️⃣ Run using Maven
```bash
mvn spring-boot:run
```

### 4️⃣ API available at
```
http://localhost:8080/student
```

---

## 📌 Notes

- Uses DTO for clean input/output handling.
- Service layer ensures separation of logic.
- Repository layer communicates with the database.
- PATCH endpoint supports updating specific fields.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to open a PR or discussion.

---

## 📄 License

This project is open source and is free to use .

---
