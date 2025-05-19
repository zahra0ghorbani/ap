package ap.midterm_project;

import java.io.Serializable;
import java.util.Date;

public class Loan implements Serializable {
    private Book book;
    private Student student;
    private Librarian librarian;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;
    private boolean isApproved; // ← Added

    public Loan(Book book, Student student, Librarian librarian, Date loanDate, Date dueDate) {
        this.book = book;
        this.student = student;
        this.librarian = librarian;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.isApproved = false; // ← default to false
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public Librarian getLibrarian() {
        return librarian;
    }
    public boolean isLate() {
        return returnDate != null && returnDate.after(dueDate);
    }

    public void returnBook(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void approveLoan() {
        this.isApproved = true;
    }

    public String getLoanDetails() {
        return "Book: " + book.getTitle() + ", Borrowed by: " + student.getFullName() +
                ", Loan date: " + loanDate + ", Due date: " + dueDate +
                ", Approved: " + (isApproved ? "Yes" : "No");
    }



}
