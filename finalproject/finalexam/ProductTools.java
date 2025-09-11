package ap.projects.finalproject.finalexam;
import java.util.*;
import java.util.stream.Collectors;

public class ProductTools {


    public static void displayProducts(List<Product> products) {


        HashSet<Product> nProducts = new HashSet<>(products);
        ArrayList<Product> productList = new ArrayList<>(nProducts);

        productList.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));


        for (Product p : productList) {
            System.out.println(p.getName() + " : " + p.getPrice());
        }

    }

    public static String MaxMinPrice (List<Product> products) {
        int bookMax = Integer.MIN_VALUE;
        int penMax = Integer.MIN_VALUE;


        for (Product p : products) {
            int price=p.getPrice();
            if (p.getName().equalsIgnoreCase("Book")) {
                if(price>bookMax){
                    bookMax=price;
                }
            }
            if (p.getName().equalsIgnoreCase("pen")) {
                if(price>penMax){
                    penMax=price;
                }
            }

        }
        return ("penmax : "+ penMax + "- bookmax:" + bookMax);
    }



    public static List<Pen> pensNumber (List<Pen> penList) {
        public static Map<String, Long> countPensByColorAdvanced;
        Object List = null;
        Object Pen = null;
        (List < Pen > penList) {
            return (List<Pen>) penList.stream()
                    .collect(Collectors.groupingBy(
                            Pen::getColor,
                            Collectors.counting()
                    ));
        }
    }
}

