package ap.projects.finalproject.finalexam;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Pen> pens = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Pen pen1=new Pen("kian",1100,"red");
        Pen pen2=new Pen("kian",2200,"red");
        Pen pen3=new Pen("kian",3300,"red");

        Book book1 =new Book("book",3300,"ahmad","demian");
        Book book2 =new Book("book",3300,"ahmad","demian");
        Book book3 =new Book("book",5500,"ahmad","demian");
        Book book4 =new Book("book",4400,"ahmad","demian");
        products.add(pen1);
        products.add(pen2);
        products.add(pen3);
        products.add(book1);
        products.add(book2);
        products.add(book3);
        products.add(book4);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        pens.add(pen1);
        pens.add(pen2);
        pens.add(pen3);
        ProductTools.displayProducts(products);
        String massage = ProductTools.MaxMinPrice(products);
        System.out.println(massage);

        ProductTools.pensNumber(pens);


    }
}