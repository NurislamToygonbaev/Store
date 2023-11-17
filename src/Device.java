import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Device extends Product {
    private String brand;
    private String color;
    private Boolean isNew;
    private double memory;

    public Device(){
        super();
    }

    public Device(String brand, String color, Boolean isNew, double memory) {
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }

    public Device(long id, String name, String description, BigDecimal price, String brand, String color, Boolean isNew, double memory) {
        super(id, name, description, price);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }

    public Device(long id, String name, String description, BigDecimal price, ZonedDateTime createAt, String brand, String color, Boolean isNew, double memory) {
        super(id, name, description, price, createAt);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    @Override
    public Product[] addNewProduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        this.setId(MyIdGenerator.generatorId());
        while (true) {
            System.out.print("🟨 Enter product Brand: ");
            this.setBrand(scanner.nextLine());
            if (!getBrand().isBlank()) break;
            else System.err.println("Empty product Brand ❌");
        }
        while (true) {
            System.out.print("🟨 Enter product name: ");
            this.setName(scanner.nextLine());
            if (!getName().isBlank()) break;
            else System.err.println("Empty product name ❌");
        }
        while (true) {
            System.out.print("🟨 Enter product memory: ");
            this.setMemory(new Scanner(System.in).nextInt());
            if (getMemory() > 0) break;
            else System.err.println("Empty product memory ❌");
        }
        while (true) {
            System.out.print("🟨 Enter product color: ");
            this.setColor(scanner.nextLine());
            if (!getColor().isBlank()) break;
            else System.err.println("Empty product color ❌");
        }
        while (true) {
            System.out.print("🟨 Enter product description: ");
            this.setDescription(scanner.nextLine());
            if (!getDescription().isEmpty()) break;
            else System.err.println("Empty product description ❌");
        }
        System.out.print("🟨 Enter product price: ");
        this.setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.print("🟨 New product? (true or false): ");
        this.setNew(new Scanner(System.in).nextBoolean());
        this.setCreateAt(ZonedDateTime.now());

        products = Arrays.copyOf(products, products.length + 1);
        products[products.length-1] = this;
        return products;
    }

    @Override
    public void getProduct(Product[] products) {
        if (products == null){
            System.out.println("⛔ Products is empty: " + "Products[0]");
        } else {
            System.out.println(STR."""
                                                            
                    Device: ⬇️
                                                            
                    """);
            for (Product product : products) {
                if (product instanceof Device device) {
                    System.out.println(device);
                }
            }
            System.out.println("___________________________________________");
        }
    }

    @Override
    public String toString() {
        return "Device" + super.toString() +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", isNew=" + isNew +
                ", memory=" + memory +
                "} ";
    }
}
