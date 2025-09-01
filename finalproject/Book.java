package ap.projects.finalproject;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;
    private int totalRequests;
    private int totalBorrows;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
        this.totalRequests = 0;
        this.totalBorrows = 0;
    }

    public void incrementRequests() {
        totalRequests++;
    }

    public void incrementBorrows() {
        totalBorrows++;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public int getTotalBorrows() {
        return totalBorrows;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }



    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | Year: " + year + " | Available: " + (available ? "Yes" : "No");
    }
}
