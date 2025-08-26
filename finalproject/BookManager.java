package ap.projects.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
        System.out.println("Book added successfully.");
    }

    public List<Book> searchBooks(String title, String author, Integer year) {
        return books.stream()
                .filter(b -> (title == null || b.getTitle().toLowerCase().contains(title.toLowerCase()))
                        && (author == null || b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                        && (year == null || b.getYear() == year))
                .collect(Collectors.toList());
    }

    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean hasAvailable = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                hasAvailable = true;
            }
        }
        if (!hasAvailable) System.out.println("No books available at the moment.");
    }

    public List<Book> getBooks() {
        return books;
    }
}
