# Rest_API_DEMO
Here’s a clean and professional GitHub README description tailored for your project:

---

## 🛠️ RESTful CRUD API with Jersey, MySQL & Maven

This project demonstrates a RESTful API built using **Jersey (JAX-RS)** and **Apache Tomcat**, backed by a **MySQL** database. It’s a **Maven-based Java application** that performs full **CRUD operations** on a custom `alien` table.

### 🔗 Tech Stack
- Java 17
- Jersey (JAX-RS)
- Apache Tomcat 9
- MySQL 8.0
- Maven
- Postman (for API testing)

### 📦 Features
- Create, Read, Update, Delete operations on `Alien` entities
- JSON-based request/response handling
- JDBC integration with MySQL
- Tested via Postman

### 🧪 Database Setup
Create a MySQL database named `restdb` and a table:

```sql
CREATE TABLE alien (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  points INT
);
```

### 🚀 How to Run
1. Clone the repo
2. Configure your MySQL credentials in `AlienRepository.java`
3. Deploy the project to Apache Tomcat
4. Test endpoints using Postman

---

