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
            System.out.println("1. Student Menu (Register/Login)");
            System.out.println("2. Guest Menu");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 3);

            switch (choice) {
                case 1:
                    displayStudentMainMenu();
                    break;
                case 2:
                    displayGuestMenu();
                    break;
                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    return;
            }
        }
    }

    private void displayStudentMainMenu() {
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. View Registered Student Count");
            System.out.println("4. Back to Main Menu");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 4);

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
                    return;
            }
        }
    }

    private void displayGuestMenu() {
        while (true) {
            System.out.println("\n--- Guest Menu ---");
            System.out.println("1. View Registered Student Count");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 3);

            switch (choice) {
                case 1:
                    displayStudentCount();
                    break;
                case 2:
                    handleGuestBookSearch();
                    break;
                case 3:
                    return;
            }
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
        currentUser = librarySystem.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInStudentMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void displayLoggedInStudentMenu() {
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Edit My Information");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 6);

            switch (choice) {
                case 1:
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                    break;
                case 2:
                    librarySystem.editStudentInformation(currentUser);
                    break;
                case 3:
                    handleBorrowBook();
                    break;
                case 4:
                    handleReturnBook();
                    break;
                case 5:
                    librarySystem.displayAvailableBooks();
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
            }
        }
    }

    private void handleBorrowBook() {
        System.out.println("\n--- Borrow a Book ---");
        librarySystem.displayAvailableBooks();
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();

        Book selectedBook = null;
        for (Book b : librarySystem.getBookManager().getBooks()) {
            if (b.getTitle().equalsIgnoreCase(title) && b.isAvailable()) {
                selectedBook = b;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Book not found or not available.");
            return;
        }

        try {
            System.out.print("Enter start date (yyyy-mm-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter end date (yyyy-mm-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());
            librarySystem.borrowBook(currentUser, selectedBook, startDate, endDate);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }

    private void handleReturnBook() {
        System.out.println("\n--- Return a Book ---");

        if (currentUser.getBorrowRequests().isEmpty()) {
            System.out.println("You have no borrowed books.");
            return;
        }

        for (BorrowRequest req : currentUser.getBorrowRequests()) {
            System.out.println("Book: " + req.getBook().getTitle() +
                    " | Borrowed from " + req.getStartDate() +
                    " to " + req.getEndDate() +
                    " | Approved: " + (req.isApproved() ? "Yes" : "Pending"));
        }

        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();

        BorrowRequest request = null;
        for (BorrowRequest r : currentUser.getBorrowRequests()) {
            if (r.getBook().getTitle().equalsIgnoreCase(title) && !r.getBook().isAvailable()) {
                request = r;
                break;
            }
        }

        if (request == null) {
            System.out.println("No matching borrowed book found.");
            return;
        }

        librarySystem.returnBook(currentUser, request.getBook());
    }

    private void handleGuestBookSearch() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        List<Book> results = librarySystem.getBookManager().searchBooks(title, null, null);

        if (results.isEmpty()) {
            System.out.println("No books found with this title.");
        } else {
            System.out.println("\n--- Search Results ---");
            for (Book book : results) {
                System.out.println("Title: " + book.getTitle() +
                        " | Author: " + book.getAuthor() +
                        " | Year: " + book.getYear());
            }
        }
    }

    private int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
                System.out.printf("Enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}
