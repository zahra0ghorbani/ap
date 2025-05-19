package ap.midterm_project;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void studentMenu(Library library, Scanner scanner) {
        boolean running = true;
        Student currentStudent = null;

        while (running) {
            System.out.println("\n-- Student Menu --");
            System.out.println("1. Register in Library");
            System.out.println("2. Login to Library");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Borrowed Books");
            System.out.println("7. View Unavailable Books");
            System.out.println("8. Exit");

            System.out.print("Please choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Library.registerStudent(library, scanner);
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    String studentId = scanner.nextLine();
                    currentStudent = library.getStudentById(studentId);
                    if (currentStudent != null) {
                        System.out.println("Welcome back, " + currentStudent.getFullName() + "!");
                    } else {
                        System.out.println("Student not found. Please register first.");
                    }
                    break;
                case 3:
                    Library.searchBook(library, scanner);
                    break;
                case 4:
                    if (currentStudent == null) {
                        System.out.println("You must log in first.");
                        break;
                    }
                    Library.borrowBook(library, scanner, currentStudent);
                    break;
                case 5:
                    if (currentStudent == null) {
                        System.out.println("You must log in first.");
                        break;
                    }
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnBookTitle = scanner.nextLine();
                    Book returnBook = library.searchBookByTitle(returnBookTitle);
                    if (returnBook != null) {
                        currentStudent.returnBook(returnBook, library);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    if (currentStudent == null) {
                        System.out.println("You must log in first.");
                        break;
                    }
                    currentStudent.displayBorrowedBooks();
                    break;
                case 7:
                    library.displayUnavailableBooks();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }

    public void librarianMenu(Library library, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n-- Librarian Menu --");
            System.out.println("1. Edit Your Details");
            System.out.println("2. Search Book");
            System.out.println("3. Approve Pending Loan Requests");
            System.out.println("4. Confirm Book Return");
            System.out.println("5. Exit");

            System.out.print("Please choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter your employee ID:");
                    String employeeId = scanner.nextLine();
                    Librarian librarian = library.getLibrarianById(employeeId);
                    if (librarian != null) {
                        librarian.editDetails(scanner);
                    } else {
                        System.out.println("Librarian not found.");
                    }
                    break;
                case 2:
                    Library.searchBook(library, scanner);
                    break;
                case 3:
                    approveLoans(library, scanner);
                    break;
                case 4:
                    confirmBookReturn(library, scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }


    public void managerMenu(Library library, Scanner scanner) {
        boolean running = true;
        LibraryManager manager = new LibraryManager("Ali", "Dadashi", "Masters");

        while (running) {
            System.out.println("\n-- Manager Menu --");
            System.out.println("1. Register Librarian");
            System.out.println("2. View Overdue Returned Books");
            System.out.println("3. View Librarian Activity Stats");
            System.out.println("4. Exit");

            System.out.print("Please choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.registerLibrarian(library, scanner);
                    break;
                case 2:
                    manager.displayOverdueReturns(library);
                    break;
                case 3:
                    manager.displayLibrarianStats(library);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }


    private void approveLoans(Library library, Scanner scanner) {
        List<Loan> pendingLoans = library.getPendingLoans();
        if (pendingLoans.isEmpty()) {
            System.out.println("No pending loan requests.");
            return;
        }

        System.out.println("-- Pending Loan Requests --");
        for (int i = 0; i < pendingLoans.size(); i++) {
            Loan loan = pendingLoans.get(i);
            System.out.println((i + 1) + ". " + loan.getLoanDetails());
        }

        System.out.print("Enter the number of the loan to approve (0 to cancel): ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice > 0 && choice <= pendingLoans.size()) {
            Loan selectedLoan = pendingLoans.get(choice - 1);
            selectedLoan.approveLoan();
            System.out.println("Loan request approved successfully.");
        } else {
            System.out.println("Cancelled.");
        }
    }

    private void confirmBookReturn(Library library, Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = library.getStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter book title to confirm return: ");
        String title = scanner.nextLine();
        Loan loan = library.getLoanByBookAndStudent(title, student);

        if (loan == null || loan.getReturnDate() != null) {
            System.out.println("No active loan found for this book.");
            return;
        }

        loan.returnBook(new Date());
        student.getBorrowedBooks().remove(loan.getBook()); // Remove from student's list
        System.out.println("Book return confirmed successfully.");
    }

}
