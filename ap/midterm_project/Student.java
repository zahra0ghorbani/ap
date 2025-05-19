package ap.midterm_project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String studentId;
    private String major;
    private Date membershipDate;
    private List<Book> borrowedBooks;

    public Student(String firstName, String lastName, String studentId, String major, Date membershipDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.major = major;
        this.membershipDate = membershipDate;
        this.borrowedBooks = new ArrayList<>(); // Fix added here
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book, Library library) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            Loan loan = library.getLoanByBookAndStudent(book.getTitle(), this);
            if (loan != null) {
                loan.returnBook(new Date());
                System.out.println("The book \"" + book.getTitle() + "\" has been successfully returned.");
            } else {
                System.out.println("Error: The loan for this book could not be found.");
            }
        } else {
            System.out.println("You haven't borrowed this book.");
        }
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            System.out.println("Books borrowed by " + getFullName() + ":");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }
}
