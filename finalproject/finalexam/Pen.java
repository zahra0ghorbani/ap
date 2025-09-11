package ap.projects.finalproject.finalexam;
public class Pen extends Product {
    private String color;
    public Pen(String name, int price , String color) {
        super(name, price);
        this.color=color;
    }
    public String getColor() {
        return color;
    }
}
