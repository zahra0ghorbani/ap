package ap.midterm_project;

import java.io.Serializable;
import java.util.Scanner;

public class Librarian implements Serializable {
    private String firstName;
    private String lastName;
    private String employeeId;

    public Librarian(String firstName, String lastName, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void editDetails(Scanner scanner) {
        System.out.println("Editing librarian details:");
        System.out.print("Enter new first name (or press Enter to keep current): ");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isEmpty()) {
            this.firstName = newFirstName;
        }

        System.out.print("Enter new last name (or press Enter to keep current): ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            this.lastName = newLastName;
        }

        System.out.print("Enter new employee ID (or press Enter to keep current): ");
        String newEmployeeId = scanner.nextLine();
        if (!newEmployeeId.isEmpty()) {
            this.employeeId = newEmployeeId;
        }
        System.out.println("Librarian details updated successfully.");
    }
}
