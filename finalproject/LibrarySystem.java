package ap.projects.finalproject;

import java.time.LocalDate;

public class LibrarySystem {
    private StudentManager studentManager;
    private BookManager bookManager;
    private MenuHandler menuHandler;
    private Employee employee;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.bookManager = new BookManager();
        this.menuHandler = new MenuHandler(this);
        this.employee = new Employee("admin", "1234"); // default employee

        bookManager.addBook("Java Programming", "James Gosling", 1995);
        bookManager.addBook("Clean Code", "Robert C. Martin", 2008);
        bookManager.addBook("Effective Java", "Joshua Bloch", 2018);
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
        System.out.println("Not implemented yet.");
    }

    public void borrowBook(Student student, Book book, LocalDate startDate, LocalDate endDate) {
        BorrowRequest request = new BorrowRequest(student, book, startDate, endDate);
        student.addBorrowRequest(request);
        System.out.println("Borrow request submitted for book: " + book.getTitle());
    }

    public void returnBook(Student student, Book book) {
        book.setAvailable(true);
        System.out.println("Book returned successfully: " + book.getTitle());
    }

    public void displayAvailableBooks() {
        bookManager.displayAvailableBooks();
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void start() {
        menuHandler.displayMainMenu();
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}
