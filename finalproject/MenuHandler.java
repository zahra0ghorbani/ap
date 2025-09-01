package ap.projects.finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;
    private boolean employeeLoggedIn;

    public MenuHandler(LibrarySystem librarySystem) {
        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
        this.employeeLoggedIn = false;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Menu (Register/Login)");
            System.out.println("2. Guest Menu");
            System.out.println("3. Employee Menu");
            System.out.println("4. Manager Menu");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(1, 4);
            switch (choice) {
                case 1: displayStudentMainMenu(); break;
                case 2: displayGuestMenu(); break;
                case 3: handleEmployeeLogin(); break;
                case 4: handleManagerLogin(); break;
                case 5: System.out.println("Exiting system. Goodbye!"); return;
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
                case 1: handleStudentRegistration(); break;
                case 2: handleStudentLogin(); break;
                case 3: displayStudentCount(); break;
                case 4: return;
            }
        }
    }

    private void displayGuestMenu() {
        while (true) {
            System.out.println("\n--- Guest Menu ---");
            System.out.println("1. View Registered Student Count");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Back to Main Menu");
            System.out.println("4. View Simple Statistics");
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(1, 4);
            switch (choice) {
                case 1: displayStudentCount(); break;
                case 2: handleGuestBookSearch(); break;
                case 3: return;
                case 4: displayGuestStatistics(); break;
            }
        }
    }

    private void displayGuestStatistics() {
        int totalStudents = librarySystem.getStudentCount();
        int totalBooks = librarySystem.getBookManager().getBooks().size();
        int totalBorrowed = 0;
        int currentlyBorrowed = 0;
        for (Book book : librarySystem.getBookManager().getBooks()) {
            if (!book.isAvailable()) {
                totalBorrowed++;
                currentlyBorrowed++;
            }
        }
        System.out.println("\n--- Guest Simple Statistics ---");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Total Borrowed Books: " + totalBorrowed);
        System.out.println("Currently Borrowed Books: " + currentlyBorrowed);
    }

    private boolean managerLoggedIn = false;

    private void handleManagerLogin() {
        if (managerLoggedIn) {
            displayManagerMenu();
            return;
        }
        System.out.println("\n--- Manager Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        Manager m = librarySystem.getManager();
        if (m.getUsername().equals(username) && m.checkPassword(password)) {
            System.out.println("Manager login successful.");
            managerLoggedIn = true;
            displayManagerMenu();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void displayManagerMenu() {
        while (true) {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. Add Library Employee");
            System.out.println("2. Change Manager Password");
            System.out.println("3. View Employee Performance");
            System.out.println("4. View Book Statistics");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = getIntInput(1, 3);
            switch (choice) {
                case 1: handleAddEmployee(); break;
                case 2: handleChangeManagerPassword(); break;
                case 3: displayEmployeePerformance();break;
                case 4: displayBookStatistics(); break;
                case 5:
                    managerLoggedIn = false;
                    System.out.println("Manager logged out.");
                    return;
            }
        }
    }
    private void displayBookStatistics() {
        List<Book> books = librarySystem.getBookManager().getBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        System.out.println("\n--- Book Statistics ---");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Total Requests: " + book.getTotalRequests());
            System.out.println("Total Borrows: " + book.getTotalBorrows());
            System.out.println("----------------------");
        }
    }

    private void displayEmployeePerformance() {
        List<Employee> employees = librarySystem.getManager().getEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n--- Employee Performance ---");
        for (Employee emp : employees) {
            System.out.println("Username: " + emp.getUsername());
            System.out.println("Books Added: " + emp.getAddedBooksCount());
            System.out.println("Total Borrowed Books: " + emp.getTotalBorrowed());
            System.out.println("Total Received Books: " + emp.getTotalReceived());
            System.out.println("----------------------------");
        }
    }


    private void handleAddEmployee() {
        System.out.print("Enter new employee username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new employee password: ");
        String password = scanner.nextLine();
        librarySystem.getManager().addEmployee(username, password);
    }


    private void handleChangeManagerPassword() {
        System.out.print("Enter current password: ");
        String current = scanner.nextLine();
        if (!librarySystem.getManager().checkPassword(current)) {
            System.out.println("Wrong password.");
            return;
        }
        System.out.print("Enter new password: ");
        String newPass = scanner.nextLine();
        librarySystem.getManager().setPassword(newPass);
        System.out.println("Password changed.");
    }


    private void handleEmployeeLogin() {
        if (employeeLoggedIn) {
            displayEmployeeMenu();
            return;
        }
        System.out.println("\n--- Employee Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        Employee emp = librarySystem.getEmployee();
        if (emp.getUsername().equals(username) && emp.checkPassword(password)) {
            System.out.println("Employee login successful.");
            employeeLoggedIn = true;
            displayEmployeeMenu();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void displayEmployeeMenu() {
        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register New Book With Details");
            System.out.println("4. Search Book");
            System.out.println("5. Edit Book Information");
            System.out.println("6. View Borrow History of a Student");
            System.out.println("7. Approve/Deny Borrow Request");
            System.out.println("8. Change Employee Password");
            System.out.println("9. View Total Borrow Count");
            System.out.println("10. Activate/Deactivate Student");
            System.out.println("11. Receive Book from Student");
            System.out.println("12. Logout");
            System.out.print("Please enter your choice: ");
            int choice = getIntInput(1, 9);
            switch (choice) {
                case 1: handleAddBook(); break;
                case 2: System.out.println("Feature not implemented yet: Remove Book"); break;
                case 3: handleRegisterBookDetails(); break;
                case 4: handleEmployeeBookSearch(); break;
                case 5: handleEditBookInformation(); break;
                case 6: handleStudentBorrowHistory(); break;
                case 7: handleApproveDenyBorrowRequest(); break;
                case 8: handleChangeEmployeePassword(); break;
                case 9: displayTotalBorrowCount(); break;
                case 10: handleToggleStudentStatus(); break;
                case 11: handleReceiveBookFromStudent(); break;
                case 12: employeeLoggedIn = false; System.out.println("Employee logged out."); return;
            }
        }
    }

    private void handleReceiveBookFromStudent() {
        System.out.print("Enter student's username: ");
        String username = scanner.nextLine();

        Student target = librarySystem.getStudentManager().getStudents().stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        if (target == null) {
            System.out.println("Student not found.");
            return;
        }

        List<BorrowRequest> borrowedBooks = new ArrayList<>();
        for (BorrowRequest req : target.getBorrowRequests()) {
            if (!req.isReturned() && req.isApproved()) {
                borrowedBooks.add(req);
            }
        }

        if (borrowedBooks.isEmpty()) {
            System.out.println("This student has no borrowed books to return.");
            return;
        }

        System.out.println("\n--- Borrowed Books by " + target.getName() + " ---");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            BorrowRequest req = borrowedBooks.get(i);
            System.out.println((i + 1) + ". " + req.getBook().getTitle() + " | From: " + req.getStartDate() + " To: " + req.getEndDate());
        }

        System.out.print("Enter the number of the book to receive (0 to cancel): ");
        int choice = getIntInput(0, borrowedBooks.size());
        if (choice == 0) return;

        BorrowRequest selectedRequest = borrowedBooks.get(choice - 1);
        librarySystem.returnBook(target, selectedRequest.getBook());
    }

    private void handleToggleStudentStatus() {
        System.out.print("Enter student's username: ");
        String username = scanner.nextLine();
        Student target = librarySystem.getStudentManager().getStudents().stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst()
                .orElse(null);
        if (target == null) {
            System.out.println("Student not found.");
            return;
        }
        target.setActive(!target.isActive());
        System.out.println("Student " + target.getName() + " is now " + (target.isActive() ? "Active" : "Inactive"));
    }






    private void handleStudentBorrowHistory() {
        System.out.print("Enter student's username: ");
        String username = scanner.nextLine();

        Student target = librarySystem.getStudentManager().getStudents().stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        if (target == null) {
            System.out.println("Student not found.");
            return;
        }

        if (target.getBorrowRequests().isEmpty()) {
            System.out.println("No borrow history for this student.");
            return;
        }

        System.out.println("\n--- Borrow History of " + target.getName() + " ---");
        for (BorrowRequest req : target.getBorrowRequests()) {
            System.out.println(req);
        }
    }

    private void displayTotalBorrowCount() {
        List<BorrowRequest> requests = librarySystem.getAllBorrowRequests();
        System.out.println("\nTotal Borrow Requests: " + requests.size());
    }
    private void handleApproveDenyBorrowRequest() {
        System.out.println("\n--- Borrow Requests ---");
        List<Student> students = librarySystem.getStudentManager().getStudents();
        List<BorrowRequest> pendingRequests = new ArrayList<>();

        for (Student s : students) {
            for (BorrowRequest r : s.getBorrowRequests()) {
                if (!r.isApproved()) {
                    pendingRequests.add(r);
                }
            }
        }

        if (pendingRequests.isEmpty()) {
            System.out.println("No pending borrow requests.");
            return;
        }

        for (int i = 0; i < pendingRequests.size(); i++) {
            BorrowRequest r = pendingRequests.get(i);
            System.out.println((i + 1) + ". " + r.getBook().getTitle() + " | Student: " + r.getStudent().getName());
        }

        System.out.print("Enter request number to approve/deny (0 to cancel): ");
        int choice = getIntInput(0, pendingRequests.size());
        if (choice == 0) return;

        BorrowRequest selectedRequest = pendingRequests.get(choice - 1);
        System.out.print("Approve this request? (yes/no): ");
        String decision = scanner.nextLine().trim().toLowerCase();
        if (decision.equals("yes")) {
            selectedRequest.approve();
            System.out.println("Request approved.");
        } else {
            System.out.println("Request denied.");
        }
    }


    private void handleEmployeeBookSearch() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        List<Book> results = librarySystem.getBookManager().searchBooks(title, null, null);
        if (results.isEmpty()) {
            System.out.println("No books found with this title.");
        } else {
            System.out.println("\n--- Search Results ---");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private void handleEditBookInformation() {
        System.out.print("Enter the title of the book to edit: ");
        String title = scanner.nextLine();
        List<Book> results = librarySystem.getBookManager().searchBooks(title, null, null);
        if (results.isEmpty()) {
            System.out.println("Book not found.");
            return;
        }
        Book book = results.get(0);
        System.out.println("Editing Book: " + book);
        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.trim().isEmpty()) book.setTitle(newTitle);
        System.out.print("Enter new author (leave blank to keep current): ");
        String newAuthor = scanner.nextLine();
        if (!newAuthor.trim().isEmpty())  book.setAuthor(newAuthor);
        System.out.print("Enter new year (0 to keep current): ");
        int newYear = 0;
        try {
            newYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ignored) {}
        if (newYear > 0) book.setYear(newYear);
        System.out.println("Book information updated: " + book);
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
            if (!currentUser.isActive()) {
                System.out.println("Your account is deactivated. Contact library employee.");
                currentUser = null;
                return;
            }
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
                case 1: System.out.println("\n--- My Information ---"); System.out.println(currentUser); break;
                case 2: librarySystem.editStudentInformation(currentUser); break;
                case 3: handleBorrowBook(); break;
                case 4: handleReturnBook(); break;
                case 5: librarySystem.displayAvailableBooks(); break;
                case 6: currentUser = null; System.out.println("Logged out successfully."); return;
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
            System.out.println("Book: " + req.getBook().getTitle() + " | Borrowed from " + req.getStartDate() + " to " + req.getEndDate() + " | Approved: " + (req.isApproved() ? "Yes" : "Pending"));
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
                System.out.println("Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Year: " + book.getYear());
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

    private void handleAddBook() {
        System.out.println("\n--- Add Book ---");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        int year;
        while (true) {
            try {
                System.out.print("Enter publication year: ");
                year = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a number.");
            }
        }
        librarySystem.getBookManager().addBook(title, author, year);
        System.out.println("Book added successfully: " + title);
    }

    private void handleRegisterBookDetails() {
        System.out.println("\n--- Register New Book With Details ---");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        int year;
        while (true) {
            try {
                System.out.print("Enter publication year: ");
                year = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a number.");
            }
        }
        librarySystem.getBookManager().addBook(title, author, year);
        System.out.println("Book registered successfully: " + title + " | " + author + " | " + year);
    }


    private void handleChangeEmployeePassword() {
        System.out.println("\n--- Change Employee Password ---");
        System.out.print("Enter current password: ");
        String currentPassword = scanner.nextLine();
        if (!librarySystem.getEmployee().checkPassword(currentPassword)) {
            System.out.println("Incorrect current password.");
            return;
        }
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        librarySystem.getEmployee().setPassword(newPassword);
        System.out.println("Password changed successfully.");
    }

    private void displayAllBorrowRequests() {
        List<BorrowRequest> requests = librarySystem.getAllBorrowRequests();
        if (requests.isEmpty()) {
            System.out.println("No borrow requests found.");
            return;
        }
        System.out.println("\n--- All Borrow Requests ---");
        for (BorrowRequest req : requests) {
            System.out.println(req);
        }
    }
}
