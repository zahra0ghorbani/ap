package ap.projects.finalproject;

import java.time.LocalDate;

public class BorrowRequest {
    private Student student;
    private Book book;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean approved;

    public BorrowRequest(Student student, Book book, LocalDate startDate, LocalDate endDate) {
        this.student = student;
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approved = false;
    }

    public Student getStudent() { return student; }
    public Book getBook() { return book; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isApproved() { return approved; }
    public void approve() {
        this.approved = true;
        this.book.setAvailable(false);
    }
}
