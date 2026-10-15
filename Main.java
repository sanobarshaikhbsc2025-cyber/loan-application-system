package com.loanapp;

import java.util.Scanner;

import com.loanapp.model.User;
import com.loanapp.service.AdminService;
import com.loanapp.service.LoanService;
import com.loanapp.service.UserService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(scanner);
        AdminService adminService = new AdminService(scanner);
        LoanService loanService = new LoanService(scanner);

        boolean running = true;

        while (running) {
            System.out.println("\n========== LOAN APPLICATION SYSTEM ==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Forgot Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    userService.registerUser();
                    break;
                case "2":
                    User loggedInUser = userService.login();
                    if (loggedInUser != null) {
                        if ("ROLE_ADMIN".equalsIgnoreCase(loggedInUser.getRole())) {
                            adminService.showAdminMenu(loggedInUser);
                        } else {
                            showUserDashboard(loggedInUser, loanService, scanner);
                        }
                    }
                    break;
                case "3":
                    userService.forgotPassword();
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showUserDashboard(User user, LoanService loanService, Scanner scanner) {
        boolean userSession = true;
        while (userSession) {
            System.out.println("\n----- Welcome, " + user.getFname() + " " + user.getLname() + " -----");
            System.out.println("1. Apply for Loan");
            System.out.println("2. View My Loan Applications");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    loanService.applyForLoan(user);
                    break;
                case "2":
                    loanService.viewUserLoans(user);
                    break;
                case "3":
                    userSession = false;
                    System.out.println("You have been logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}