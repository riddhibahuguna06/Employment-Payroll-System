# Employee Payroll System

## 📋 Description

A Java-based payroll management system designed to handle employee data, calculate salaries with tax deductions, and generate comprehensive payroll reports. This project demonstrates core Object-Oriented Programming (OOP) principles, exception handling, package organization, and file I/O operations.

## 🎯 Learning Objectives

This is a **learning project** focused on mastering:

- **Object-Oriented Programming (OOP)** - Classes, objects, encapsulation, inheritance, and polymorphism
- **Exception Handling** - Custom exceptions, try-catch blocks, and error management
- **Java Packages** - Organizing code into logical package structures
- **Try-with-Resources** - Safe file handling and resource management
- **File I/O Operations** - Reading and writing employee data to files
- **Data Validation** - Input validation and error prevention

## ✨ Features

### Employee Management
- Add new employees with validation
- Update employee information
- Delete employees from system
- Store employee data (ID, name, department, salary)
- Search for specific employees

### Salary Calculation
- Calculate gross salary
- Automatic tax deduction (10%)
- Bonus management
- Calculate net salary (gross - deductions + bonus)

### Payroll Reports
- Generate individual salary slips
- Create monthly payroll summary
- Export reports to files
- View employee details

### Data Persistence
- Save employee records to file
- Load employee data from file
- Use try-with-resources for safe file operations
- Persistent data storage between sessions

### Exception Handling
- Custom exceptions for invalid operations
- Input validation with meaningful error messages
- Graceful error handling throughout application
- Exception chaining for better debugging

## 🛠️ Technologies Used

- **Language:** Java (JDK 8 or higher)
- **Concepts:** OOP, Exception Handling, Packages
- **File I/O:** BufferedReader, BufferedWriter, Try-with-Resources
- **Data Structures:** ArrayList, HashMap
- **IDE:** Eclipse, IntelliJ IDEA, or VS Code

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Git installed

### Steps
1. Clone the repository
```bash
   git clone https://github.com/riddhibahugun06/Employee-Payroll-System.git
   cd Employee-Payroll-System
```

2. Compile the project
```bash
   javac -d bin src/com/payroll/**/*.java
```
3. Run the application
```bash
   java -cp bin com.payroll.Main

   ## 📁 Project Structure

   Employee-Payroll-System/
├── src/
│   └── com/payroll/
│       ├── models/
│       ├── exceptions/
│       ├── services/
│       ├── utils/
│       └── Main.java
├── data/
│   └── employees.txt
├── README.md
└── .gitignore
```