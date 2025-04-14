# hw2 - Expense Tracker Application

The homework will be based on this project named "Expense Tracker", where users will be able to add/remove daily transaction. 

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.

## Features

- Add expense transactions with amount, category, timestamp
- Real-time updates to the transaction table and total expense values
- Input validation for amount, category values
- Using MVC architecture to separate model, view and controllers
- Using filter on the expense table
- Adding validation on the filter inputs

## Technologies Used

- Java (Swing GUI)
- MVC Pattern
- JUnit (For testing)

## Build & Testing

1. With Apache Ant installed, run ```ant``` in the root directory containing the build.xml build file

2. Run ```ant compile``` to generate the class files

3. Run ```ant test``` to compile all unit tests and run them

## How to run (from Terminal, if compile instructions do not work):
After building the project, run: ```java -cp bin ExpenseTrackerApp```
