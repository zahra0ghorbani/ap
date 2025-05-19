package ap.midterm_project;

import java.io.Serializable;
import java.util.*;

public class LibraryManager implements Serializable {
    private String firstName;
    private String lastName;
    private String educationLevel;

    public LibraryManager(String firstName, String lastName, String educationLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationLevel = educationLevel;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    public void registerLibrarian(Library library, Scanner scanner) {
        System.out.print("Enter Librarian's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Librarian's last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Librarian's employee ID: ");
        String employeeId = scanner.nextLine();

        Librarian librarian = new Librarian(firstName, lastName, employeeId);
        library.addLibrarian(librarian);
        System.out.println("Librarian registered successfully.");

    }

    public void displayOverdueReturns(Library library) {
        System.out.println("\n-- Overdue Returned Books --");
        boolean found = false;
        for (Loan loan : library.getAllLoans()) {
            if (loan.getReturnDate() != null && loan.getReturnDate().after(loan.getDueDate())) {
                System.out.println(loan.getLoanDetails() + " [Returned Late]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No overdue returned books found.");
        }
    }

    public void displayLibrarianStats(Library library) {
        System.out.println("\n-- Librarian Activity Stats --");

        Map<Librarian, Integer> approvals = new HashMap<>();
        Map<Librarian, Integer> returns = new HashMap<>();

        for (Loan loan : library.getAllLoans()) {
            Librarian librarian = loan.getLibrarian();
            if (librarian == null) continue;

            // Count approvals
            if (loan.isApproved()) {
                approvals.put(librarian, approvals.getOrDefault(librarian, 0) + 1);
            }

            // Count returns
            if (loan.getReturnDate() != null) {
                returns.put(librarian, returns.getOrDefault(librarian, 0) + 1);
            }
        }

        Set<Librarian> allLibrarians = new HashSet<>();
        allLibrarians.addAll(approvals.keySet());
        allLibrarians.addAll(returns.keySet());

        if (allLibrarians.isEmpty()) {
            System.out.println("No librarian activity recorded.");
            return;
        }

        for (Librarian librarian : allLibrarians) {
            int approved = approvals.getOrDefault(librarian, 0);
            int returned = returns.getOrDefault(librarian, 0);
            System.out.println(librarian.getFullName() + " (ID: " + librarian.getEmployeeId() + ") → Approved Loans: " + approved + ", Confirmed Returns: " + returned);
        }
    }

}
