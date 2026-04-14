# AddressBookPro 📒
[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8+-green)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
A simple **Java-based Contact Management System** that allows users to add, view, search, update, and delete contacts. This project uses **JDBC** to connect with a **MySQL database** and demonstrates a full CRUD application using **Java**, **DAO pattern**, and **service layer architecture**.

---

## Features

- **Add New Contact:** Store a new contact with name, phone, and email.
- **View All Contacts:** Display all contacts stored in the database.
- **Search Contact:** Search for a contact by name.
- **Update Contact:** Update the details of a contact by ID.
- **Delete Contact:** Remove a contact by name.
- **Data Validation:** Prevent empty or invalid inputs for name, phone, and email.
- **Database Integration:** Uses MySQL to store contact information.

---

## Technologies Used

- **Java 17+**
- **MySQL 8+**
- **JDBC** for database connectivity
- **DAO Design Pattern** for database operations
- **Service Layer** for business logic
- **Console-based UI** using `Scanner`

---

## Project Structure

AddressBookPro/
│
├── src/
│ ├── Contact_Management_System/
│ │ ├── DAO/
│ │ │ └── ContactDAO.java
│ │ ├── model/
│ │ │ └── Contact.java
│ │ ├── service/
│ │ │ └── ContactService.java
│ │ ├── util/
│ │ │ └── DBConnection.java
│ │ └── Main.java
│
├── README.md
└── pom.xml (if using Maven)


---

## Setup & Run ⚡

### 1. Database Setup

```sql
CREATE DATABASE cms;
USE cms;

### 2. Create Contact Table
CREATE TABLE contact (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

### 3. Update DBConnection.java with your MySQL credentials
private static final String url = "jdbc:mysql://127.0.0.1:3306/cms";
private static final String username = "root";
private static final String password = "YOUR_PASSWORD";

### 4. How to Run

Usage Example
=========CONTACT MANAGEMENT SYSTEM==========
1. Add New Contact
2. View All
3. Search
4. Update
5. Delete
6. Exit
Enter your choice: 1
Name: John Doe
Phone: 1234567890
Email: john@example.com
✅ Contact added successfully
---

### License 📝
This project is open-source and available under the MIT License.

Author

Mayank Kapoor
GitHub: https://github.com/kapoormayank9696
---

If you want, I can also **make a shorter, more attractive GitHub-ready version** that looks modern with badges for Java, MySQL, and license.  

Do you want me to do that version too?
