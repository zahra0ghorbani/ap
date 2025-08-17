package ap.projects.finalproject;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;

    public MenuHandler(LibrarySystem librarySystem) {
        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. View Registered Student Count");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 5);

            switch (choice) {
                case 1:
                    handleStudentRegistration();
                    break;
                case 2:
                    handleStudentLogin();
                    break;
                case 3:
                    displayStudentCount();
                    break;
                case 4:
                    librarySystem.displayAvailableBooks();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displayStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }

    private void handleStudentRegistration() {
        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Student student = librarySystem.authenticateStudent(username, password);

        if (student != null) {
            System.out.println("Login successful. Welcome, " + student.getName() + "!");
            currentUser = student;
            displayStudentMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void displayStudentMenu() {
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Borrow Book");
            System.out.println("2. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = getIntInput(1, 2);

            switch (choice) {
                case 1:
                    handleBorrowBook();
                    break;
                case 2:
                    return;
            }
        }
    }

    private void handleBorrowBook() {
        librarySystem.displayAvailableBooks();
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();

        List<Book> foundBooks = librarySystem.getBookManager().searchBooks(title, null, null);

        if (foundBooks.isEmpty()) {
            System.out.println("Book not found or not available.");
            return;
        }

        Book book = foundBooks.get(0);

        System.out.print("Start date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.print("End date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        librarySystem.borrowBook(currentUser, book, startDate, endDate);
    }

    private int getIntInput(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) return choice;
                else System.out.print("Please enter a valid number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
