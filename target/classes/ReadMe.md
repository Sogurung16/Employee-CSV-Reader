# Employee_CSV_Reader

Developed a maven architecture project to learn how to manipulate, read and write data onto MySQL using 
IntelliJ IDE. In addition, I also learned how to set up a connection and connect to MySQL using MySQL Workbench.
In addition, got the opportunity to emulate a microservices architecture implementation where the project consists
of a collection of small, autonomous self-contained services for e.g. writer, reader, jdbc packages e.t.c. and the DAO 
pattern.

Furthermore, I got to continue practicing my Test Driven Development (using JUnit 5 Jupiter) technique and Object-Oriented Programming.
Made use of Logging (using log4j apache package) to log the performance of my system. 

Most importantly this project introduced Concurrency (Multi-threading) to achieve faster process times thanks to the
asynchronous code when writing the data onto MySQL Database.

Results of program (Best Shortest processing times):
- EmployeeRecords: 7 seconds
- EmployeeRecordsLarge: 13 seconds

#Pre-requisites
- Maven
- JUnit 5 Jupiter
- log4j
- mysql-connector-java

#Executing program
- src/main/java/com/sparta/sonam/employeecsvproject/Main.java - Execute the main class which will begin the 
reading and writing process of the program for the 2 files(EmployeeRecords and EmployeeRecordsLarge).
- src/main/java/com/sparta/sonam/employeecsvproject/dao - Contains the Employee Data Access Object.
- src/main/java/com/sparta/sonam/employeecsvproject/jbdc - Contains the Java Database Connectivity classes 
  (Connection Manager to connect to database and some SQLQueries interface class with static String variables).
- src/main/java/com/sparta/sonam/employeecsvproject/dto - Contains the Employee Data Transfer Object
- src/main/java/com/sparta/sonam/employeecsvproject/printer - Static printer class for print statements.
- src/main/java/com/sparta/sonam/employeecsvproject/util - Contains a utility class which loads a property file.
- src/main/java/com/sparta/sonam/employeecsvproject/writer - Writes to the database.
- src/main/java/com/sparta/sonam/employeecsvproject/Loader - Loads the main logic of the system.