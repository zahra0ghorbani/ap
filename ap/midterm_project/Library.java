package ap.midterm_project;

import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {
    private String libraryName;
    private List<Book> books;
    private List<Student> students;
    private List<Librarian> librarians;
    private List<Loan> loans;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.loans = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }


    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }


    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }


    public Librarian getRandomLibrarian() {
        if (!librarians.isEmpty()) {
            Random random = new Random();
            return librarians.get(random.nextInt(librarians.size()));
        }
        return null;
    }


    public void registerLoan(Loan loan) {
        loans.add(loan);
    }


    public void printStudentBorrowHistory(Student student) {
        boolean found = false;
        for (Loan loan : loans) {
            if (loan.getStudent().equals(student)) {
                System.out.println(loan.getLoanDetails());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No borrow history found.");
        }
    }

    public Loan getLoanByBookAndStudent(String bookTitle, Student student) {
        for (Loan loan : loans) {
            if (loan.getBook().getTitle().equalsIgnoreCase(bookTitle) && loan.getStudent().equals(student)) {
                return loan;
            }
        }
        return null;
    }





    public Librarian getLibrarianById(String id) {
        for (Librarian librarian : librarians) {
            if (librarian.getEmployeeId().equals(id)) {
                return librarian;
            }
        }
        return null;
    }
    public static void searchBook(Library library, Scanner scanner) {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        Book foundBook = library.searchBookByTitle(title);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
    public static void loginStudent(Library library, Scanner scanner) {
        System.out.print("Enter your student ID: ");
        String studentId = scanner.nextLine();

        Student student = library.getStudentById(studentId);
        if (student != null) {
            System.out.println("Welcome back, " + student.getFullName() + "!");
        } else {
            System.out.println("Student not found. Please register first.");
        }
    }
    public static void registerStudent(Library library, Scanner scanner) {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter your major: ");
        String major = scanner.nextLine();
        Date membershipDate = new Date();

        Student student = new Student(firstName, lastName, studentId, major, membershipDate);
        library.addStudent(student);

        System.out.println("You have successfully registered as a student.");


    }
    public static void borrowBook(Library library, Scanner scanner, Student student) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();

        Book book = library.searchBookByTitle(title);
        if (book != null) {
            library.borrowBook(student, book);
        } else {
            System.out.println("Book not found.");
        }
    }
    public void borrowBook(Student student, Book book) {
        if (book != null && !student.getBorrowedBooks().contains(book)) {
            Date loanDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(loanDate);
            calendar.add(Calendar.DAY_OF_YEAR, 14);
            Date dueDate = calendar.getTime();

            Librarian librarian = getRandomLibrarian();
            Loan loan = new Loan(book, student, librarian, loanDate, dueDate);
            registerLoan(loan);

            System.out.println("Loan request submitted. Awaiting librarian approval.");
        } else {
            System.out.println("Book is not available or you have already borrowed it.");
        }
    }

    public void displayUnavailableBooks() {
        System.out.println("\nBooks not available for borrowing:");
        for (Book book : books) {
            boolean isAvailable = true;
            for (Loan loan : loans) {
                if (loan.getBook().equals(book) && loan.getReturnDate() == null) {
                    isAvailable = false;
                    break;
                }
            }
            if (!isAvailable) {
                System.out.println(book);
            }
        }
    }

    public List<Loan> getAllLoans() {
        return loans;
    }

    public List<Loan> getPendingLoans() {
        List<Loan> pending = new ArrayList<>();
        for (Loan loan : loans) {
            if (!loan.isApproved()) {
                pending.add(loan);
            }
        }
        return pending;
    }


}
