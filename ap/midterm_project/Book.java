
package ap.midterm_project;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int yearPublished;
    private int numberOfPages;

    public Book(String title, String author, int yearPublished, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.numberOfPages = numberOfPages;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", Pages: " + numberOfPages;
    }
}
