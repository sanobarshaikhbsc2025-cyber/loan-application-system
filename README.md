# Loan Application System - Stage 3 Complete

## Project Overview
This project is a Java Console-based Loan Application System. Stage 3 introduces a full loan lifecycle management module, enabling users to apply for loans, view loan statuses, and allowing administrators to review submitted applications alongside existing user management capabilities.

---

## 🛠 Tech Stack & Setup
- **Language:** Java (JDK 8 or higher)
- **Database:** MySQL Server
- **Driver:** `mysql-connector-j-26.7.0.jar` (Located in `/lib`)
- **IDE:** Eclipse / Spring Tool Suite (STS)

---

## 📁 Project Structure

```text
stage2/
├── lib/
│   └── mysql-connector-j-26.7.0.jar
├── sql/
│   ├── schema.sql           <-- Master Database Setup Script
│   └── migration.sql        <-- Upgrade script from Stage 1/2
├── src/main/java/com/loanapp/
│   ├── Main.java            <-- Main Application Entry Point
│   ├── db/
│   │   └── DBConnection.java
│   ├── model/
│   │   ├── User.java
│   │   └── Loan.java
│   ├── dao/
│   │   ├── UserDAO.java
│   │   └── LoanDAO.java
│   ├── service/
│   │   ├── UserService.java
│   │   ├── AdminService.java
│   │   ├── LoanService.java
│   │   └── EmailService.java
│   └── util/
│       ├── AuditLogger.java
│       └── ValidationUtil.java
├── HANDOVER_STAGE3.txt      <-- Developer Quick Setup Guide
└── README.md                <-- Project Documentation


Setup Instructions
Database Setup

Open MySQL Workbench or MySQL CLI.

Run the script located at sql/schema.sql to create loan_app_db along with users and loans tables.

Database Credentials

Open com.loanapp.db.DBConnection.java.

Ensure the DB URL (jdbc:mysql://localhost:3306/loan_app_db), username, and password match your local MySQL configuration.

Running the Application

Open com.loanapp.Main.java in Eclipse.

Right-click > Run As > Java Application.

🔑 Default Credentials for Testing
Admin User: username: admin | password: Admin@123

Standard User: username: srushti111 | password: Srushti@123

✅ Modules Completed Up to Stage 3
[x] Stage 1: User Registration, Login Authentication, Password Reset.

[x] Stage 2: Admin Dashboard, Account Activation/Deactivation, User Profile Editing.

[x] Stage 3: Loan Module (Apply for Loan, View Loan Applications, Status Tracking, DAO & Service integrations).

📋 Roadmap for Stage 4 Developer
[ ] Loan Repayment & EMI Module: Schedule and calculate EMI repayments.

[ ] Extended Admin Workflows: Admin approval/rejection reason logging and status transitions.

[ ] Payment Status Tracking: Mark loans as PAID / IN_DEFAULT.


3. Press **`Ctrl + S`** to save.
4. Click back to **`Preview`**[cite: 8]—you will see the **Project Structure** rendered in a clean grey box!

---

### Step 2: Final Zip Export

1. Right-click the **`stage2`** root folder in Package Explorer (left panel)[cite: 8].
2. Select **Export...** $\rightarrow$ **General** $\rightarrow$ **Archive File** $\rightarrow$ **Next**.
3. Choose your **Desktop** as the location, set the file name as `LoanApp_Stage3_Complete.zip`, and click **Finish**.

Now your documentation looks clean and readable, and your package is ready for delivery!