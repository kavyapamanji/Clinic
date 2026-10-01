# CarePoint Clinic Appointment System

Full-stack Java application built with HTML/CSS/JavaScript, Spring Boot, Spring JDBC and MySQL.

## Features
- View doctors
- Register patients
- Book appointments
- View appointments
- Mark appointments as completed
- Cancel appointments
- Dashboard counts
- REST API
- JDBC parameterized SQL

## Architecture
Frontend -> REST Controller -> Service -> JDBC Repository -> MySQL

## Requirements
- JDK 17+
- Maven 3.9+ (or an IDE with Maven support)
- MySQL 8+

## Database
Create the database in MySQL:

```sql
CREATE DATABASE IF NOT EXISTS clinicdb;
```

The application creates tables and sample data automatically.

Default credentials:
- username: root
- password: password

If your MySQL password differs, set DB_PASSWORD.

Windows PowerShell:
```powershell
$env:DB_PASSWORD="YOUR_MYSQL_PASSWORD"
```

Windows CMD:
```cmd
set DB_PASSWORD=YOUR_MYSQL_PASSWORD
```

Linux/macOS:
```bash
export DB_PASSWORD="YOUR_MYSQL_PASSWORD"
```

## Run
Open a terminal in this project folder:

```bash
mvn spring-boot:run
```

Then open:
http://localhost:8080

## API
GET /api/doctors
GET /api/patients
POST /api/patients
GET /api/appointments
POST /api/appointments
PATCH /api/appointments/{id}/status
DELETE /api/appointments/{id}

This is a learning/portfolio application. It is not intended for real patient medical records or production clinical use.
