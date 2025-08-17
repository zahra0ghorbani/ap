package ap.projects.finalproject;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();

        // Sample books
        books.add(new Book("Java Basics", "John Doe", 2020));
        books.add(new Book("Advanced Java", "Jane Smith", 2021));
        books.add(new Book("Database Systems", "Ali Reza", 2019));
    }

    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        books.stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);
    }

    public void searchBooks(String title, String author, int year) {
        System.out.println("\n--- Search Results ---");
        books.stream()
                .filter(b -> (title == null || b.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || b.getAuthor().equalsIgnoreCase(author)) &&
                        (year == -1 || b.getYear() == year))
                .forEach(System.out::println);
    }
}
