package ap.projects.finalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class BorrowRequest implements Serializable {
    private Student student;
    private Book book;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean approved;
    private boolean returned;

    public BorrowRequest(Student student, Book book, LocalDate startDate, LocalDate endDate) {
        this.student = student;
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approved = false;
        this.returned = false;
        this.book.incrementRequests();
    }

    public Student getStudent() { return student; }
    public Book getBook() { return book; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isApproved() { return approved; }
    public boolean isReturned() { return returned; }

    public void approve() {
        this.approved = true;
        this.book.setAvailable(false);
        this.book.incrementBorrows();
    }

    public void markReturned() {
        this.returned = true;
        this.book.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Book: " + book.getTitle() +
                " | Student: " + student.getName() +
                " | From: " + startDate + " To: " + endDate +
                " | Approved: " + (approved ? "Yes" : "Pending") +
                " | Returned: " + (returned ? "Yes" : "No");
    }
}
