import java.util.Arrays;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;
    private Product[] products = new Product[]{};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }



    public static User menuRegister(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("🟨 Enter first name: ");
            user.setFirstName(scanner.nextLine());
            if (!user.getFirstName().isBlank()) break;
            else System.err.println("Empty first name ❌");
        }
        while (true) {
            System.out.print("🟨 Enter last name: ");
            user.setLastName(scanner.nextLine());
            if (!user.getLastName().isBlank()) break;
            else System.err.println("Empty last name ❌");
        }
        while (true) {
            System.out.print("🟨 Enter your gender: ");
            user.setGender(scanner.nextLine());
            if (user.getGender().equalsIgnoreCase("male") ||
                    user.getGender().equalsIgnoreCase("female")) break;
            else System.err.println("Incorrect gender, Please use the male or female");
        }
        while (true) {
            System.out.print("🟨 Enter Email: ");
            user.setEmail(scanner.nextLine());
            if (user.getEmail().endsWith("@gmail.com")) break;
            else System.err.println("Incorrect email. Please use the domain @gmail.com");
        }
        while (true) {
            System.out.print("🟨 Enter password: ");
            user.setPassword(scanner.nextLine());
            if (user.getPassword().length() >= 4) break;
            else System.err.println("Write more 4 symbol ❌");
        }
        return user;
    }

    public static User[] registration(User[] userArray, User user) {
        userArray = Arrays.copyOf(userArray, userArray.length + 1);
        userArray[userArray.length - 1] = user;
        return userArray;
    }

    public static User login(User[] users) {
        String login, pass;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("enter your email: ");
            
            login = scanner.nextLine();
            if (login.endsWith("@gmail.com")) break;
            else System.err.println("Incorrect email. Please use the domain @gmail.com");
        }
        while (true) {
            System.out.print("enter your password: ");
            pass = scanner.nextLine();
            if (pass.length() >= 4) break;
            else System.err.println("Write more 4 symbol ❌");

        }
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(login) && user.getPassword().equals(pass)) {
                return user;
            } else {
                System.err.println("Re-write the email and password correct! ");
            }
        }
        return login(users);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
