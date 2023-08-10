# JAVA_ASSIGNMENT_2

# User Login Form using Java Swing

This is a simple user login form application built using Java Swing. 
The application allows users to input their username and password, insert the data into a MySQL database, and display the contents of the database table.

## Features

- Input fields for username and password.
- Submit button to insert user data into the database.
- Show Database button to display the contents of the database table.
- Display area to show messages and retrieved database contents.

## Prerequisites

- Java Development Kit (JDK) installed.
- MySQL database server installed and running.
- MySQL JDBC driver JAR included in the project classpath.

## Usage

1. Clone the repository or download the source code.

2. Open the project in your favorite Java IDE (e.g., Eclipse, IntelliJ).

3. Configure your MySQL database connection parameters:
   - Update the `jdbcUrl`, `user`, and `pass` variables in the `displayDatabaseContents()` method and `insertDataIntoDatabase()` method with your MySQL server details.

4. Run the `UserLoginForm` class to launch the application's GUI.

5. Use the following steps to interact with the application:
   - Enter a username and password in the input fields.
   - Click the "Submit" button to insert the data into the MySQL database.
   - Click the "Show Database" button to retrieve and display the contents of the `student1` table in the `JTextArea`.

6. If an error occurs while connecting to the database, an error message will be displayed.

## Notes

- Ensure that the MySQL database is running and accessible.
- Adjust the database table and column names in the code to match your setup.
- Modify the table creation script in the code to match the attributes you want to store in the database.
