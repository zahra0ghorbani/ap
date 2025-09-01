package ap.projects.finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
    private String username;
    private String password;
    private List<Book> addedBooks;
    private int totalBorrowed;
    private int totalReceived;

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
        this.addedBooks = new ArrayList<>();
        this.totalBorrowed = 0;
        this.totalReceived = 0;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void addBook(Book book) {
        addedBooks.add(book);
        totalBorrowed++;
    }

    public void receiveBook() {
        totalReceived++;
    }

    public int getAddedBooksCount() {
        return addedBooks.size();
    }

    public int getTotalBorrowed() {
        return totalBorrowed;
    }

    public int getTotalReceived() {
        return totalReceived;
    }
}


