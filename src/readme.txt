🌞 Solar Energy Monitoring System

A Java-based desktop application to monitor, visualize, and store solar energy data such as energy produced, consumed, and stored.
The application uses Java Swing for GUI and MySQL for persistent data storage.

📌 Project Overview

The Solar Energy Monitoring System allows users to:

Enter solar energy values

Visualize energy usage using progress bars

Store energy data in a MySQL database

Track historical records for analysis

This project demonstrates concepts of Java GUI development, JDBC, and database integration.

🏗️ Project Structure
SolarEnergyApp
│
├── src
│   ├── ui
│   │   └── SolarEnergyUI.java
│   │
│   ├── dao
│   │   └── EnergyDAO.java
│   │
│   ├── model
│   │   └── EnergyData.java
│   │
│   └── util
│       └── DBConnection.java
│
├── lib
│   └── mysql-connector-j.jar
│
├── database.sql
│
└── README.md

📂 Package Explanation
🔹 ui

Contains all GUI-related classes

SolarEnergyUI.java

Main window of the application

Uses Swing components (JFrame, JButton, JTextField, JProgressBar)

🔹 dao (Data Access Object)

Handles all database operations

EnergyDAO.java

Inserts solar energy data into MySQL

Executes SQL queries using JDBC

🔹 model

Represents the data structure

EnergyData.java

Stores produced, consumed, and stored energy values

🔹 util

Contains utility/helper classes

DBConnection.java

Manages MySQL database connection

🔹 lib

External libraries

Includes MySQL JDBC Connector

✨ Key Features

✅ User-friendly Swing GUI

📊 Real-time visualization using progress bars

💾 MySQL database integration

🔁 Persistent data storage

🧩 Modular code structure (MVC-style)

🚫 Input validation to avoid invalid data

🛠️ Technologies Used:-

-Java (JDK 8+)

-Java Swing

-JDBC

-MySQL

-MySQL Workbench

-IntelliJ IDEA / Eclipse