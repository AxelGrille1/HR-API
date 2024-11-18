# **Human Resources REST API**

This project is a simple REST API for managing employee data in a Human Resources system. It allows clients to perform CRUD (Create, Read, Update, Delete) operations on employees.

---

## **Features**
- Add new employees to the system.
- Retrieve details of a specific employee.
- List all employees.
- Update employee information.
- Delete employees.
- In-memory database (H2) for development and testing.

---

## **Technologies Used**
- **Java** (JDK 17+ recommended)
- **Spring Boot** (Framework for building the REST API)
- **Spring Data JPA** (For database interactions)
- **H2 Database** (In-memory database)
- **Lombok** (For reducing boilerplate code)

---

## **Getting Started**

### **1. Prerequisites**
Make sure you have the following installed:
- **Java Development Kit (JDK)** 17 or later.
- **Maven** (for building the project).

---

### **2. Clone the Repository**
```bash
git clone https://github.com/yourusername/human-ressources-api.git
cd human-ressources-api
```

---

### **3. Build and Run the Application**

#### **Using Maven**
1. Build the project:
   ```bash
   mvn clean install
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

#### **Using the Jar File**
1. Build the jar:
   ```bash
   mvn package
   ```
2. Run the jar:
   ```bash
   java -jar target/human-ressources-api-0.0.1-SNAPSHOT.jar
   ```

The application will start on **`http://localhost:9000`**.

---

### **4. Access H2 Database Console**
- Open the H2 console in your browser:
  ```
  http://localhost:9000/h2-console
  ```
- Use the following credentials:
  - **JDBC URL**: `jdbc:h2:mem:testdb`
  - **Username**: `sa`
  - **Password**: *(leave empty)*

---

## **API Endpoints**

### **Base URL**: `http://localhost:9000/api/employees`

| HTTP Method | Endpoint                 | Description                            |
|-------------|--------------------------|----------------------------------------|
| **GET**     | `/`                      | Retrieve all employees.               |
| **GET**     | `/{id}`                  | Retrieve a specific employee by ID.   |
| **POST**    | `/`                      | Add a new employee.                   |
| **PUT**     | `/{id}`                  | Update an existing employee by ID.    |
| **DELETE**  | `/{id}`                  | Delete an employee by ID.             |

---

### **Sample API Calls**

#### **1. Retrieve All Employees**
```http
GET /api/employees
```
**Response:**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "mail": "john.doe@example.com",
    "password": "hashed_password"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Smith",
    "mail": "jane.smith@example.com",
    "password": "hashed_password"
  }
]
```

#### **2. Add a New Employee**
```http
POST /api/employees
```
**Request Body:**
```json
{
  "firstName": "Alice",
  "lastName": "Johnson",
  "mail": "alice.johnson@example.com",
  "password": "secure_password"
}
```

#### **3. Update Employee Information**
```http
PUT /api/employees/1
```
**Request Body:**
```json
{
  "firstName": "Alice",
  "lastName": "Johnson",
  "mail": "alice.updated@example.com",
  "password": "new_secure_password"
}
```

#### **4. Delete an Employee**
```http
DELETE /api/employees/1
```

---

## **Project Structure**
```
src
├── main
│   ├── java/com/human_ressources/api
│   │   ├── controller/    # Controllers for handling HTTP requests
│   │   ├── model/         # Entity classes (e.g., Employee)
│   │   ├── repository/    # JPA repositories (e.g., EmployeeRepository)
│   │   └── service/       # Business logic (e.g., EmployeeService)
│   ├── resources
│   │   ├── application.properties # Application configurations
│   │   └── data.sql               # Initial data (optional)
└── test                          # Unit and integration tests
```

---

## **Contributing**
Feel free to submit issues or pull requests. Contributions are welcome!

---

## **License**
This project is licensed under the [MIT License](LICENSE).
