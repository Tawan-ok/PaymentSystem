# 🏦 Spring Boot Payment & Authentication API

🚀 A **Payment API** and **Authentication API** built with **Spring Boot**, featuring **JWT Authentication**.  
Supports **Stateless Authentication**, **Refresh Token**, and **Payment Processing**.  

---

## 📌 **Features**
✅ **JWT Authentication**  
✅ **Refresh Token (Stateless Authentication)**  
✅ **Payment API** (Create/View Payment Transactions)  
✅ **Spring Boot 3 + Gradle**  
✅ **PostgreSQL Database**  
✅ **Docker + Docker Compose**  

📌 **Upcoming Features:**  
🔜 **Webhook Notification**  

---

## 🛠 **Technologies Used**
| Technology | Description |
|------------|------------|
| **Java 17+** | Main language for Spring Boot |
| **Spring Boot 3** | The primary framework for the API |
| **Spring Security** | Handles Authentication and JWT |
| **PostgreSQL** | Database for the system |
| **Redis (Optional)** | Used for storing Refresh Tokens |
| **Docker & Docker Compose** | Manages running the system |

---

## 📌 **Installation & Usage**
### **🚀 1. Clone the project**
```bash
git clone https://github.com/your-github/payment-auth-service.git
cd payment-auth-service
```

### **🛠 2. Create a `.env` file (Optional)**
```plaintext
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/payment_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=password
JWT_SECRET_KEY=supersecretkey12345678901234567890
JWT_ACCESS_EXPIRATION=900000  # 15 minutes
JWT_REFRESH_EXPIRATION=86400000  # 1 day
```

### **📌 3. Run the project using Docker**
```bash
docker-compose up -d
```

📌 **Or run locally (without Docker)**
```bash
./gradlew bootRun
```

---

## 🔑 **API Authentication**
### **📌 1. Register a new user**
```http
POST /api/auth/register
```
📌 **Request**
```json
{
  "username": "user1",
  "password": "password123"
}
```

📌 **Response**
```json
{
  "message": "User registered successfully"
}
```

---

### **📌 2. Login**
```http
POST /api/auth/login
```
📌 **Request**
```json
{
  "username": "user1",
  "password": "password123"
}
```

📌 **Response**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIs...",
  "refreshToken": "eyJhbGciOiJIUzI1NiIs..."
}
```

---

### **📌 3. Refresh Access Token**
```http
POST /api/auth/refresh
```
📌 **Request**
```json
{
  "refreshToken": "eyJhbGciOiJIUzI1NiIs..."
}
```

📌 **Response**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIs..."
}
```

---

## 💳 **Payment API**
### **📌 1. Create a payment request**
```http
POST /api/payments
Authorization: Bearer <access_token>
```
📌 **Request**
```json
{
  "orderId": "ORD1234",
  "amount": 500.00
}
```

📌 **Response**
```json
{
  "id": 1,
  "orderId": "ORD1234",
  "amount": 500.00,
  "status": "PENDING"
}
```

---

### **📌 2. Retrieve payment transactions**
```http
GET /api/payments
Authorization: Bearer <access_token>
```
📌 **Response**
```json
[
  {
    "id": 1,
    "orderId": "ORD1234",
    "amount": 500.00,
    "status": "SUCCESS"
  }
]
```

---

## 🛠 **Deployment**
📌 **Run in production using Docker**
```bash
docker build -t payment-auth .
docker run -p 8080:8080 payment-auth
```

📌 **Deploy on Cloud (AWS, GCP, DigitalOcean, etc.)**
- Use Docker + Kubernetes (K8s)
- Implement CI/CD with GitHub Actions or GitLab CI/CD

---

## 📌 **Contributing**
If you want to contribute, please fork the repository and submit a Pull Request. 🎯  

---
