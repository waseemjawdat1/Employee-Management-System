# Employee Management System

A JavaFX-based desktop application for managing employee records, built as part of the COMP2311 course at Birzeit University. The system handles various employee types and provides full CRUD operations (Create, Read, Update, Delete) with validation, structured GUI design, and file handling.

## 📌 Features

- 📋 Add, view, update, and delete employee records
- 📂 Load and save data from/to text files
- 📊 Statistical reports for salary, sorting, and totals
- 🧮 Supports multiple employee types:
  - Hourly Employee
  - Salaried Employee
  - Commission-based Employee
  - Employee with base salary + commission
- 📷 Upload employee photo
- 📅 Date of birth selection with age validation (must be 16+)
- 📑 Validation for:
  - Phone number (must start with 059 or 056)
  - Email format
  - Name and address input
  - Salary and working hours

## 🖥️ Technologies Used

- **Java**  
- **JavaFX** *(GUI and layout using BorderPane, VBox, HBox, GridPane, etc.)*  
- **OOP Concepts** *(inheritance, interfaces, abstract classes)*  
- **Event Handling**  
- **Custom Exceptions**  
- **File I/O**  

## 🧱 Project Structure

- `Employee.java` – base class with shared attributes
- `Address.java` – encapsulated address information
- `HourlyEmployee.java`, `SalariedEmployee.java`, `CommissionEmployee.java`, `EmployeeBasedCommission.java` – subclasses with salary logic
- GUI classes for:
  - Add Employee
  - View/Search Employee
  - Update/Delete Employee
  - Statistical Report

## 📂 File Handling

The application supports reading employee data from a structured text file using the `readFromFile(File f)` method. Each line in the file represents an employee, with fields separated by commas.

## 📄 File Format (Input Data)

Each line in the file must follow one of these formats, depending on the employee type:

```
Hourly Employee,<FirstName>,<LastName>,<DOB>,<Street-City-Country>,<Phone>,<Email>,<Nationality>,<Designation>,<Education>,<PhotoPath>,<Hours>,<Rate>

Salaried Employee,<FirstName>,<LastName>,<DOB>,<Street-City-Country>,<Phone>,<Email>,<Nationality>,<Designation>,<Education>,<PhotoPath>,<AnnualSalary>

Commession Employee,<FirstName>,<LastName>,<DOB>,<Street-City-Country>,<Phone>,<Email>,<Nationality>,<Designation>,<Education>,<PhotoPath>,<MonthlySales>

Employee Based Commession,<FirstName>,<LastName>,<DOB>,<Street-City-Country>,<Phone>,<Email>,<Nationality>,<Designation>,<Education>,<PhotoPath>,<MonthlySales>,<BaseSalary>
```


> ⚠️ Ensure that paths are valid, emails and phone numbers follow the required format, and all fields are properly filled.

## 🚀 How to Run

1. Open the project in Eclipse or any Java IDE
2. Make sure JavaFX is configured correctly
3. Run the `Main.java` class

## 👨‍💻 Author

Waseem Sisan  
Computer Science Student  
Birzeit University

