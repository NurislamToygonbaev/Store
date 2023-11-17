import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Book extends Product {
    private String authorFullName;

    public Book() {
        super();
    }

    public Book(long id, String name, String description, BigDecimal price, ZonedDateTime createAt, String authorFullName) {
        super(id, name, description, price, createAt);
        this.authorFullName = authorFullName;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }


    @Override
    public Product[] addNewProduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        this.setId(MyIdGenerator.generatorId());
        while (true) {
            System.out.print("🟨 Enter Book name: ");
            this.setName(scanner.nextLine());
            if (!getName().isBlank()) break;
            else System.err.println("Empty product name ❌");
        }
        while (true) {
            System.out.print("🟨 Enter Book description: ");
            this.setDescription(scanner.nextLine());
            if (!getDescription().isBlank()) break;
            else System.err.println("Empty product description ❌");
        }
        System.out.print("Enter product prise: ");
        setPrice(new Scanner(System.in).nextBigDecimal());
        while (true) {
            System.out.print("🟨 Enter Book author full name: ");
            this.setAuthorFullName(scanner.nextLine());
            if (!getAuthorFullName().isBlank()) break;
            else System.err.println("Empty product author full name ❌");
        }
        this.setCreateAt(ZonedDateTime.now());

        products = Arrays.copyOf(products, products.length + 1);
        products[products.length-1] = this;
        return products;
    }


    @Override
    public void getProduct(Product[] products) {
        if (products == null) {
            System.out.println("⛔ Products is empty: " + "Products[0]");
        } else {
            System.out.println(STR."""
                                                            
                    Book: ⬇️
                                                            
                    """);
            for (Product product : products) {
                if (product instanceof Book book) {
                    System.out.println(book);
                }
            }
            System.out.println("___________________________________________");
        }
    }

    @Override
    public String toString() {
        return "Book" + super.toString() +
                "authorFullName='" + authorFullName + '\'' +
                "}";
    }
}
