Author: Chidicivok

SimBank - Java console Banking simulation system

It is a console based banking simulation system developed in Java using OOP principles

The application allows users to ;
- Register accounts
- Login securely
- Deposit money
- Withdraw money
- View Account balance
- View Transaction history


Features include;
- Username validation
- Password validation
- Login attempt restriction
- Deposit and withdrawal processing
- Transaction history tracking
- Modular OOP architecture
- Input validation handling


Technologies used;
- Java
- Object Oriented Programming
- Java Time API
- NetBeans IDE


Project Background

SimBank is a redesigned and significantly improved version of an earlier academic banking simulation exercise originally developed using procedural programming techniques.

The original implementation focused primarily on basic transaction processing and console interaction. This version rebuilds the system using Object-Oriented Programming (OOP) principles, modular service-oriented architecture, reusable validation utilities, transaction history tracking, improved input validation, and cleaner separation of concerns to better reflect real-world software engineering practices.



Structure 
com.simbank
│
├── models
│   ├── User.java
│   ├── Account.java
│   └── Transaction.java
│
├── services
│   └── BankService.java
│
├── utils
│   └── ValidationUtil.java
│
└── BankApp.java
