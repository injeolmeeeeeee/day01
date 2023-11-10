import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    private static List<String> cart = new ArrayList<>();
    
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your shopping cart");
        try {
            while (true) {
            System.out.print("> ");
            String input = scan.nextLine().trim().toLowerCase();

            if (input.equals("list")) {
                listCart();
            } else if (input.startsWith("add")) {
                addItem(input);
            } else if (input.startsWith("delete")) {
                input = input.substring(7);
                deleteItem(input);
            } else {System.out.println("Invalid command.");
            }
        }
    } finally {scan.close();
    }

    }

    public static void listCart() {
        for (int i = 0; i<cart.size(); i++) {
            System.out .println((i+1) + ". " + cart.get(i));
            }
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        }    
    }

    public static void addItem(String input) {
        input = input.substring(4);
        String[] items = input.split(",");
        for (String item: items) {
            if (!cart.contains(item)) {
                cart.add(item);
                System.out.println("You have added " + item);
            } else {System.out.println("You have " + item + " in your cart");
            }
        }
    }

    public static void deleteItem(String input) {
        if (input.isEmpty()) {
            System.out.println("Invalid index. Please provide a valid index.");
            return;
        }
        int itemsToDelete = Integer.parseInt(input);
        try {
            if (itemsToDelete > 0 && itemsToDelete < cart.size()) {
                cart.remove(itemsToDelete-1);
                System.out.println(itemsToDelete + " removed from cart");
            } else {System.out.println("Invalid index. Please provide a valid number.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid index. Please provide a valid number.");
    }
        
    }
}