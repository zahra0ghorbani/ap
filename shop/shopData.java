package shop;

import java.util.ArrayList;

public class shopData {
    public static void main(String[] args) {
        Pen pen1 = new Pen(200, "red");
        Pen pen2 = new Pen(100, "black");
        Book book1 = new Book("Book 1", 200.0);
        Book book2 = new Book("Book 2", 100.0);
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Pen> pens = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        pens.add(pen1);
        pens.add(pen2);
        for (Pen pen : pens ){
            System.out.println("Pen color:" + pen.color + "\n pen price:" + pen.price);
        }
        for (Book book : books) {
            System.out.println("book name:" + book.name + "\n book price:" + book.price);

        }
    }
}
