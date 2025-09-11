package ap.projects.finalproject.finalexam;
import java.util.Objects;

public class Product {
    private String name ;
    private int price;
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }



    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
