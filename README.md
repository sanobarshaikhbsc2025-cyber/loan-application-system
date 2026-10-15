# Loan Application System

A console-based Loan Application System written in Java with a MySQL database. The project has three modules: user accounts (registration, login, password reset), an admin dashboard for managing users, and a loan module where users apply for loans and track them. It is built in layers (model, DAO, service, utility) and talks to MySQL through JDBC.


---

## Features

### 1. User accounts
- **Registration** with validation: 10-digit mobile number, proper email format, unique username and email, and a strong password (minimum 8 characters with an uppercase letter, a lowercase letter, a digit and a special character). Location is optional.
- **Login** using either username or email.
- **Account lock:** a regular user is locked after 3 wrong password attempts, and the system shows how many attempts are left.
- **Forgot password:** reset the password using username or email, with the same password rules.

### 2. Loan module (user side)
- **Apply for a loan:** the user enters the loan amount and the purpose. The application is saved with the status `PENDING` and a confirmation email is shown.
- **View my loan applications:** shows every loan the logged-in user has applied for, with its ID, amount, purpose and status.

### 3. Admin dashboard
- Search users
- View user details
- Edit user information (leave a field blank to keep its current value)
- Activate and deactivate a user
- Delete a user
- Every admin action is written to `audit_log.txt` (who did what, to which user, and when).
- A notification email is generated for every account action. Emails are simulated and printed to the console.

---

## Tech stack
- Java (JDK 8 or higher)
- MySQL 8
- JDBC with `mysql-connector-j` (included in `lib/`)
- Eclipse / VS Code

---

## Project structure

```text
loan-application-system/
├── lib/
│   └── mysql-connector-j-26.7.0.jar
├── sql/
│   ├── schema.sql          # creates the database, tables and the admin account
│   └── migration.sql       # only needed to upgrade an older copy of the database
├── src/main/java/com/loanapp/
│   ├── Main.java           # entry point and menus
│   ├── db/DBConnection.java
│   ├── model/              # User.java, Loan.java
│   ├── dao/                # UserDAO.java, LoanDAO.java
│   ├── service/            # UserService, AdminService, LoanService, EmailService
│   └── util/               # ValidationUtil, AuditLogger
├── screenshots/
└── README.md
```

---

## Database tables

**users:** user_id, fname, lname, mobile, email, location, username, password, status (active/inactive), failed_attempts, user_role (ROLE_USER/ROLE_ADMIN), lastmodifieddate, created_date

**loans:** loan_id, user_id (linked to users), amount, purpose, status (default `PENDING`), created_at

---

## How to run

1. **Create the database.** Open MySQL Workbench, run `sql/schema.sql`. This creates `loan_app_db`, both tables and the admin account.
2. **Set your MySQL login.** Open `src/main/java/com/loanapp/db/DBConnection.java` and change `DB_USER` and `DB_PASSWORD` to match your own MySQL setup.
3. **Add the driver.** Add `lib/mysql-connector-j-26.7.0.jar` to the project's build path (Eclipse: right-click project, Build Path, Add JARs).
4. **Run** `Main.java` as a Java Application.

### Admin login for testing
| Username | Password |
|----------|----------|
| admin | Admin@123 |

Any normal user can be created with the Register option.

---

## Known limitations
- Passwords are stored as plain text because this is a learning project. A real system should hash them (for example with BCrypt).
- Emails are only simulated on the console, not sent for real.
- Admins can manage user accounts but cannot yet review or approve loan applications.
- It is a console application, so there is no graphical interface.
