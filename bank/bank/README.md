# Bank Project

## Overview
This project is a simple banking application that allows users to manage their accounts and transactions. It provides functionalities for user authentication, transaction management, and account details rendering.

## Project Structure
```
bank
├── src
│   └── main
│       ├── java
│       │   └── edu
│       │       └── cwi
│       │           ├── AuthController.java
│       │           ├── TransactionsController.java
│       │           ├── UserAccount.java
│       │           └── UserAccountController.java
│       └── resources
│           └── templates
├── pom.xml
├── README.md
└── .gitignore
```

## Files Description

- **AuthController.java**: Handles user authentication and session management.
- **TransactionsController.java**: Implements CRUD operations for managing transactions.
- **UserAccount.java**: Represents a user account with properties such as username, balance, and a list of transactions.
- **UserAccountController.java**: Manages user account-related operations and rendering of account details.
- **resources/templates**: Contains HTML templates for rendering views.
- **pom.xml**: Maven configuration file for project dependencies and build settings.
- **README.md**: Documentation for the project.
- **.gitignore**: Specifies files and directories to be ignored by Git.

## Setup Instructions
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Use Maven to build the project:
   ```
   mvn clean install
   ```
4. Run the application using your preferred method (e.g., through an IDE or command line).

## Usage Guidelines
- Access the application through the designated URL (to be specified).
- Follow the on-screen instructions for user registration and login.
- Manage transactions through the provided interface.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any suggestions or improvements.