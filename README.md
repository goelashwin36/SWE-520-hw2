# Expense Tracker Application

## Overview

This is a simple expense tracker application which lets users add daily transactions (amount and category), keep a list of all the entries and calculate total expenses.

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

## How to run (from Terminal):
After building the project, run: ```java -cp bin ExpenseTrackerApp```
