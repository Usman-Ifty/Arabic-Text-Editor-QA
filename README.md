# Arabic Text Editor - Quality Assurance Suite
### Software Verification & Validation | Group Assignment

## 📋 Project Overview
This project represents the **Professional Quality Assurance (QA) Phase** for the Arabic Text Editor application. Our team has reverse-engineered the existing alpha codebase, implemented a robust testing suite, and established a professional DevOps workflow to ensure software reliability.

The application is a **3-Layer Desktop Application** supporting:
- Multilingual editing (Arabic/Urdu/Farsi)
- TF-IDF Text Analysis
- Document Pagination & Auto-Save
- Markdown Support

## 🏗️ Architecture & Design Patterns
The system enforces a strict **3-Layer Architecture**:
1.  **Presentation Layer (`pl`)**: UI components handling user interactions (Arabic-enabled text areas).
2.  **Business Logic Layer (`business`)**: Core logic implementing the **Command Pattern** (`ImportCommand`, `SaveCommand`) and **Facade Pattern** (`TextEditor`).
3.  **Data Access Layer (`dal`)**: Persistence handling via **Singleton** Database Connections and File I/O.

## 🛠️ Prerequisites
- **Java JDK 21** or higher.
- **MariaDB** (User: `root`, Pass: `taqi123`).
- **Maven** (for dependency management and testing).

## 🚀 Installation & Setup

### 1. Database Setup
Ensure MariaDB is running. The project requires the `realeditor` database.
Run the provided SQL script to initialize the schema:
```bash
mysql -u root -ptaqi123 < setup_database.sql
```

### 2. Configuration
Verify `config.properties` matches your local database credentials:
```properties
db.url = jdbc:mariadb://localhost:3306/realeditor
db.username = root
db.password = taqi123
```

## 🧪 Testing Strategy
Our QA suite covers **100% of critical business paths** through a mix of White-Box Analysis and Automated Unit Testing.

### A. White-Box Analysis
We mathematically analyzed critical control flows (see `Report/Analysis.pdf`):
- **Cyclomatic Complexity Calculations** for Auto-Save & Pagination.
- **Control Flow Graphs (CFGs)** and Edge definitions.
- **Independent Test Paths** defined using Set Theory.

### B. Automated JUnit 5 Tests
We implemented modular, swappable tests in the `Testing` directory (separated from source):

| Layer | Test Coverage |
| :--- | :--- |
| **Business** | Command execution, TF-IDF algorithms (Positive/Negative/Boundary). |
| **Data** | SHA1/MD5 Integrity, Singleton Pattern verification, Mocking. |
| **Presentation** | Input validation, Error handling resilience. |

### How to Run Tests
**Option 1: Automated Script (Recommended)**
Double-click `run_tests_v2.bat` in the root directory.

**Option 2: Maven Command Line**
```bash
mvn test
```

## 👥 Contributors
- **Usman Ifty**
- **Shahzaib**

---
*Submitted for Software Testing Assignment 1 - Spring 2026*
