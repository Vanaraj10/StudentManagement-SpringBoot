# Student API

A RESTful API built with Spring Boot for managing student information. This application provides CRUD (Create, Read, Update, Delete) operations for student records stored in MongoDB.

## 🚀 Features

- **Student Management**: Complete CRUD operations for student records
- **MongoDB Integration**: Uses MongoDB as the database with Spring Data MongoDB
- **RESTful Architecture**: Clean REST API endpoints
- **Data Validation**: Prevents duplicate roll numbers and email addresses
- **Spring Boot**: Built on Spring Boot 3.5.0 with Java 17

## 📋 Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Data Model](#data-model)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Technologies Used](#technologies-used)

## 🛠 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+** or use the included Maven wrapper
- **MongoDB** (local installation or MongoDB Atlas account)

## 📦 Installation

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd StudentApi
   ```

2. **Build the project:**
   ```bash
   ./mvnw clean install
   ```
   Or on Windows:
   ```cmd
   mvnw.cmd clean install
   ```

## ⚙️ Configuration

The application is configured through [`src/main/resources/application.properties`](src/main/resources/application.properties):

```properties
spring.application.name=StudentApi
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/studentdb?retryWrites=true&w=majority&appName=Practise
```

**Important:** Update the MongoDB connection string with your own credentials before running the application.

### MongoDB Setup Options:

1. **Local MongoDB:**
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/studentdb
   ```

2. **MongoDB Atlas (Cloud):**
   - Create a MongoDB Atlas account
   - Create a cluster and database
   - Update the connection string with your credentials

## 🚀 Running the Application

1. **Using Maven wrapper:**
   ```bash
   ./mvnw spring-boot:run
   ```

2. **Using Java directly:**
   ```bash
   java -jar target/StudentApi-0.0.1-SNAPSHOT.jar
   ```

3. **Using your IDE:**
   - Run the [`StudentApiApplication`](src/main/java/com/example/StudentApi/StudentApiApplication.java) class

The application will start on `http://localhost:8080`

## 🔌 API Endpoints

All endpoints are prefixed with `/students`

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/students` | Get all students | None |
| GET | `/students/{rollNo}` | Get student by roll number | None |
| POST | `/students` | Create a new student | Student JSON |
| PUT | `/students/{rollNo}` | Update existing student | Student JSON |
| DELETE | `/students/{rollNo}` | Delete student by roll number | None |

### Example Requests:

**Create a Student (POST /students):**
```json
{
    "rollNo": "CS001",
    "name": "John Doe",
    "age": 20,
    "department": "Computer Science",
    "email": "john.doe@example.com"
}
```

**Update a Student (PUT /students/CS001):**
```json
{
    "name": "John Smith",
    "age": 21,
    "department": "Computer Science",
    "email": "john.smith@example.com"
}
```

## 📊 Data Model

The [`Student`](src/main/java/com/example/StudentApi/model/Student.java) entity contains the following fields:

| Field | Type | Description | Constraints |
|-------|------|-------------|-------------|
| `rollNo` | String | Student roll number (Primary Key) | Unique, Required |
| `name` | String | Student's full name | Required |
| `age` | int | Student's age | Required |
| `department` | String | Academic department | Required |
| `email` | String | Student's email address | Unique, Required |

## 🏗 Project Structure

```
src/
├── main/
│   ├── java/com/example/StudentApi/
│   │   ├── controller/
│   │   │   └── StudentController.java      # REST API endpoints
│   │   ├── model/
│   │   │   └── Student.java               # Student entity
│   │   ├── repository/
│   │   │   └── StudentRepository.java     # Data access layer
│   │   ├── service/
│   │   │   ├── StudentService.java        # Service interface
│   │   │   └── impl/
│   │   │       └── StudentServiceImpl.java # Service implementation
│   │   └── StudentApiApplication.java     # Main application class
│   └── resources/
│       └── application.properties         # Application configuration
└── test/
    └── java/com/example/StudentApi/
        └── StudentApiApplicationTests.java # Test class
```

### Key Components:

- **[`StudentController`](src/main/java/com/example/StudentApi/controller/StudentController.java)**: REST controller handling HTTP requests
- **[`StudentService`](src/main/java/com/example/StudentApi/service/StudentService.java)**: Business logic interface
- **[`StudentServiceImpl`](src/main/java/com/example/StudentApi/service/impl/StudentServiceImpl.java)**: Service implementation with validation
- **[`StudentRepository`](src/main/java/com/example/StudentApi/repository/StudentRepository.java)**: MongoDB data access layer
- **[`Student`](src/main/java/com/example/StudentApi/model/Student.java)**: Entity model representing student data

## 🧪 Testing

Run the tests using Maven:

```bash
./mvnw test
```

## 🔧 Technologies Used

- **Spring Boot 3.5.0** - Application framework
- **Spring Data MongoDB** - Database integration
- **Spring Web** - REST API support
- **MongoDB** - NoSQL database
- **Maven** - Build tool and dependency management
- **Java 17** - Programming language
