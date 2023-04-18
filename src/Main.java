import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "Mobile", 350));
        list.add(new Product(2, "Laptop", 252.3f));
        list.add(new Product(3, "Refrigerator", 450));
        list.add(new Product(3, "TV", 330));
        list.add(new Product(3, "Geyser", 488.5f));
        list.add(new Product(3, "Headphone", 412));
        list.add(new Product(3, "Earphone", 43.4f));
        list.add(new Product(3, "WebCam", 120));
        list.add(new Product(3, "Mouse", 212));
        list.add(new Product(3, "Printer", 450.5f));

        System.out.println("Price of products : ");
        list.stream()
                .map(product -> product.price)
                .forEach(s -> System.out.println(s));

        List<Float> pp = list.stream()
                .filter(product -> product.price > 300)
                .map(product -> product.price)
                .collect(Collectors.toList());
        System.out.println("Price list greater than 300 : " + pp);

        long count = list.stream()
                .filter(product -> product.price > 300)
                .count();
        System.out.println("Number of products having price greater than 300 : " + count);

        Float sum = list.stream()
                .map(product -> product.price)
                .reduce(0.0f, (ans, price) -> ans + price);
        System.out.println("Sum of price of all products : " + sum);

        Product Max = list.stream()
                .max((productA, productB) -> productA.price > productB.price ? 1 : -1)
                .get();
        System.out.println("Maximum price among all products : " + Max.price);

        Product Min = list.stream()
                .min((productA, productB) -> productA.price > productB.price ? 1 : -1)
                .get();
        System.out.println("Minimum price among all products : " + Min.price);

        list.stream()
                .filter(p -> p.price == 488.5)
                .forEach(s -> System.out.println("Product with price 488.5 : " + s.name));
    }
}