package ap.projects.finalproject.finalexam;

public class Book extends Product {
    private String author;
    private String title;
    public Book( String name,int price, String author, String title) {
        super(name, price);
        this.author=author;
        this.title=title;

    }
}
