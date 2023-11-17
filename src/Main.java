import java.util.Arrays;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] userArray = new User[]{};
        User currentUser = null;
        int counter = 0;
        boolean isRunning = true;
        while (isRunning) {
            methodMenu();
            switch (scanner.nextLine().toLowerCase()) {
                case "1" -> {
                    User userRegister = User.menuRegister(new User());
                    userArray = User.registration(userArray, userRegister);
                    System.out.println("Registration saved successfully! ✅");
                    counter++;
                }
                case "2" -> {
                    if (counter > 0) {
                        currentUser = User.login(userArray);
                        System.out.println(">>>> LogIn successful <<<< ✅");
                        boolean isTrue = true;
                        while (isTrue){
                            System.out.println(STR. """
                            ~Profile:📟 \{ currentUser.getFirstName() } \{ currentUser.getLastName() }
                            Email:📧 \{ currentUser.getEmail() }
                               """ );
                            menuInside();
                            switch (scanner.nextLine().toLowerCase()){
                                case "0", "logout" -> isTrue = false;
                                case "1", "add" -> {
                                    System.out.println("Choice category: 1-Book📚📖 or 2-Device💻📱");
                                    System.out.print("----->> ");
                                    switch (scanner.nextLine().toLowerCase()){
                                        case "1", "book" ->{
                                            if (currentUser != null) {
                                                currentUser.setProducts(new Book().addNewProduct(currentUser.getProducts()));
                                                System.out.println(">>>> Successfully added Book <<<< ✅");
                                            }
                                        }
                                        case "2", "device" -> {
                                            if (currentUser != null) {
                                                currentUser.setProducts(new Device().addNewProduct(currentUser.getProducts()));
                                                System.out.println(">>>> Successfully added Device <<<< ✅");
                                            }
                                        }
                                        default -> System.out.println("👉 choose the right option");
                                    }
                                }
                                case "2", "all product" -> {
                                    if (currentUser != null) Product.getAllProducts(currentUser.getProducts());
                                }

                                case "3", "all book" -> {
                                    if (currentUser != null) new Book().getProduct(currentUser.getProducts());
                                }
                                case "4", "all device" -> {
                                    if (currentUser != null) new Device().getProduct(currentUser.getProducts());
                                }
                                case "5", "delete" -> {
                                    System.out.print("Enter ID: ");
                                    if (currentUser != null){
                                        Product[] products = Product.deleteProduct(currentUser.getProducts(), scanner.nextLong());
                                        currentUser.setProducts(products);
                                    }
                                    System.out.println("Book 🗑️ successful");
                                }
                                case "6", "delete products" -> {
                                    System.out.print("Enter how much: ");
                                    int length = scanner.nextInt();
                                    long[] ids = new long[length];
                                    for (int i = 0; i < length; i++) {
                                        System.out.print("Enter IDs: ");
                                        ids[i] = scanner.nextLong();
                                    }
                                    if (currentUser != null){
                                        Product[] products = Product.deleteProduct(currentUser.getProducts(), ids);
                                        currentUser.setProducts(products);
                                    }
                                    System.out.println("Book 🗑️ successful");
                                }
                            }
                        }
                    } else System.err.println("create Account 🆕");
                }
                case "3" -> isRunning = false;
                default -> System.out.println("👉 choose the right option");
            }
        }
    }

    private static void methodMenu() {
        System.out.println(STR."""
                                
                🟢 1. Register
                🟢 2. Login
                🔴 3. Exit
                                
                """);
        System.out.print("---->> ");
    }

    private static void menuInside() {
        System.out.println(STR."""           
                🔙❕  0. logout
                🆕➕  1. Add new Product
                🛍️🛄  2. Get all Products
                📚📕  3. Get all Book
                💻☎️  4. Get all Device
                🗑️🚮  5. Delete product by ID
                🗑️🚮  6. Delete products by IDs
                                
                """);
        System.out.print("---->> ");
    }
}