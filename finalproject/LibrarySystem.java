package ap.projects.finalproject;

import java.time.LocalDate;

public class LibrarySystem {
    private StudentManager studentManager;
    private BookManager bookManager;
    private MenuHandler menuHandler;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.bookManager = new BookManager();
        this.menuHandler = new MenuHandler(this);
    }

    public int getStudentCount() {
        return studentManager.getStudentCount();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
    }

    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }

    public void editStudentInformation(Student student) {
        System.out.println("Not implemented.");
    }

    public void borrowBook(Student student, Book book, LocalDate startDate, LocalDate endDate) {
        BorrowRequest request = new BorrowRequest(student, book, startDate, endDate);
        student.addBorrowRequest(request);
        System.out.println("Borrow request submitted.");
    }

    public void returnBook(Student student, Book book) {
        System.out.println("Not implemented.");
    }

    public void displayAvailableBooks() {
        bookManager.displayAvailableBooks();
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public void start() {
        menuHandler.displayMainMenu();
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}
