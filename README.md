# Student Management System 🎓

A web-based Student Management System built using Java and Spring Boot. It provides REST APIs for managing student records and a responsive frontend for interacting with those APIs.

## 🚀 Live Demo

**Live Application:** https://student-management-api-3po8.onrender.com/

## ✨ Features

- **CRUD Operations:** Create, retrieve, update, and delete student records.
- **Search Students:** Search by name, age, email, and keyword.
- **Age Range Filtering:** Filter students within a specified age range.
- **Sorting:** Sort students by name and age.
- **Student Count:** Display the total number of students.
- **Pagination:** Navigate through student results using pages.
- **Dark Mode:** Switch between light and dark themes with saved preferences.
- **Toast Notifications:** Display success, error, and validation messages.
- **Input Validation:** Validate student details.
- **Exception Handling:** Handle errors such as missing students and duplicate IDs.
- **Responsive Interface:** Use the frontend on desktop and mobile screens.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | Application framework |
| Spring Web | REST API development |
| Maven | Dependency management and build |
| HTML | Frontend structure |
| CSS | Styling and responsive layout |
| JavaScript | Frontend functionality and API requests |
| Git & GitHub | Version control and source code |
| Docker | Application containerization |
| Render | Cloud deployment |

## 📁 Project Structure

```text
student-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/utkarsh/studentapi/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── exception/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       └── StudentApiApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       └── application.properties
│   └── test/
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
├── HELP.md
└── README.md
```

## ⚙️ Run Locally

### Prerequisites

- Java version compatible with the project
- Git
- IntelliJ IDEA or another Java IDE

### 1. Clone the repository

```bash
git clone https://github.com/utkkrsh7/student-api.git
cd student-api
```

### 2. Start the application

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Alternatively, open the project in IntelliJ IDEA and run `StudentApiApplication.java`.

### 3. Open the application

Visit:

http://localhost:8080/

## 🔗 REST API Reference

**Base path:** `/students`

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Retrieve all students |
| POST | `/students` | Add a student |
| GET | `/students/{id}` | Retrieve a student by ID |
| PUT | `/students/{id}` | Update a student |
| DELETE | `/students/{id}` | Delete a student |
| GET | `/students/count` | Get the student count |
| GET | `/students/search?name={name}` | Search by name |
| GET | `/students/search/age?age={age}` | Search by age |
| GET | `/students/search/email?email={email}` | Search by email |
| GET | `/students/search/keyword?keyword={keyword}` | Search by keyword |
| GET | `/students/search/age-range?min={min}&max={max}` | Filter by age range |
| GET | `/students/sort/age` | Sort by age |
| GET | `/students/sort/name` | Sort by name |

### Example: Create a Student

**Request**

```http
POST /students
Content-Type: application/json
```

**Request body**

```json
{
  "id": 1,
  "name": "Aarav Sharma",
  "age": 20,
  "email": "aarav@example.com"
}
```

Use a REST client such as Postman or the application frontend to send requests.

## 💾 Data Storage

The application currently stores student records in memory using a Java collection. No database is configured, so records may reset when the application restarts.

## 🌐 Deployment

The application is deployed on Render using Docker and connected to GitHub for source control and deployment updates.

**Live URL:** https://student-management-api-3po8.onrender.com/

## 🎯 Learning Outcomes

This project demonstrates practical experience with:

- Building RESTful APIs using Spring Boot.
- Implementing CRUD operations.
- Organizing code using controller, service, model, DTO, and exception packages.
- Handling validation and API errors.
- Connecting a JavaScript frontend to REST endpoints.
- Implementing frontend features such as pagination and dark mode.
- Deploying a web application with Docker and Render.
- Managing source code using Git and GitHub.

## 👨‍💻 Author

**Utkarsh**

GitHub: https://github.com/utkkrsh7/student-api
