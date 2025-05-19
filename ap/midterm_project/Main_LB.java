package ap.midterm_project;

import java.util.Scanner;

public class Main_LB {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        Library library = FileManager.loadLibraryData();


        System.out.println("Enter user type (Student / Librarian / Manager): ");
        String userType = scanner.nextLine();

        if (userType.equalsIgnoreCase("Student")) {
            menu.studentMenu(library, scanner);
        } else if (userType.equalsIgnoreCase("Librarian")) {
            menu.librarianMenu(library, scanner);
        } else if (userType.equalsIgnoreCase("Manager")) {
            menu.managerMenu(library, scanner);
        }

        FileManager.saveLibraryData(library);
        scanner.close();
    }
}
