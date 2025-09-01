package ap.projects.finalproject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem implements Serializable {
    private StudentManager studentManager;
    private BookManager bookManager;
    private MenuHandler menuHandler;
    private Employee employee;
    private Manager manager;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.bookManager = new BookManager();
        this.menuHandler = new MenuHandler(this);
        this.employee = new Employee("admin", "1234");
        this.manager = new Manager("manager", "4321");

        bookManager.addBook("Java Programming", "James Gosling", 1995);
        bookManager.addBook("Clean Code", "Robert C. Martin", 2008);
        bookManager.addBook("Effective Java", "Joshua Bloch", 2018);
    }



    public Manager getManager() {
        return manager;
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
        System.out.println("There is no need for now.");
    }

    public void borrowBook(Student student, Book book, LocalDate startDate, LocalDate endDate) {
        BorrowRequest request = new BorrowRequest(student, book, startDate, endDate);
        student.addBorrowRequest(request);
        System.out.println("Borrow request submitted for book: " + book.getTitle());
    }

    public void returnBook(Student student, Book book) {
        for (BorrowRequest req : student.getBorrowRequests()) {
            if (req.getBook().equals(book) && !req.isReturned()) {
                req.markReturned();
                System.out.println("Book returned successfully: " + book.getTitle());
                return;
            }
        }
        System.out.println("No active borrow request found for this book.");
    }

    public List<Student> getAllStudents() {
        return studentManager.getStudents();
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

    public static void main(String[] args) {
        LibrarySystem system = DataStorage.loadData();
        MenuHandler menu = new MenuHandler(system);
        menu.displayMainMenu();

        DataStorage.saveData(system);

    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public List<BorrowRequest> getAllBorrowRequests() {
        List<BorrowRequest> allRequests = new ArrayList<>();
        for (Student s : studentManager.getStudents()) {
            allRequests.addAll(s.getBorrowRequests());
        }
        return allRequests;
    }

}
