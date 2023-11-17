import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;

public abstract class Product {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private ZonedDateTime createAt;

    public Product() {

    }

    public Product(long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(long id, String name, String description, BigDecimal price, ZonedDateTime createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(ZonedDateTime createAt) {
        this.createAt = createAt;
    }

    public static void getAllProducts(Product[] products) {
        if (products == null) {
            System.out.println("⛔ Products is empty: " + "Products[0]");
        } else {
            System.out.println(STR."""
                                                            
                    Products: ⬇️
                                                            
                    """);
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("___________________________________________");
        }
    }

    public abstract Product[] addNewProduct(Product[] products);

    public abstract void getProduct(Product[] products);


    public static Product[] deleteProduct(Product[] products, long id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                for (int j = i; j < products.length - 1; j++) {
                    products[j] = products[j + 1];
                }
            }
        }
        return Arrays.copyOf(products, products.length -1);
    }

    public static Product[] deleteProduct(Product[] products, long[] ids) {
        for (long l : ids) {
            products = deleteProduct(products, l);
        }
        return products;
    }

    @Override
    public String toString() {
        return " " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createAt=" + createAt +
                ',';
    }
}