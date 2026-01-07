package app;

import java.util.Scanner;

public class AdminCli {

    private final Inventory inventory;
    private final Scanner scanner;

   public AdminCli(Inventory inventory) {
       this.inventory = inventory;
       this.scanner = new Scanner(System.in);
   }

   public void run() {
    System.out.println("Inventory Admin CLI");
    System.out.println("Type 'help' for commands.");
    while (true) {
        System.out.print(">");
        String command = scanner.nextLine().trim();

        if (command.equals("exit")) {
            break;
        }
        else if (command.equals("help")) {
            System.out.println("Commands: add, remove, list, adjust, find, exit");
            continue;
        }
         else if (command.equals("list")) {
           for (Product p : inventory.listAll()) {
               System.out.println(p);
           }
           continue;
        }
         else if (command.equals("add")) {
             try {

                 System.out.println("Enter the SKU number of the product: ");
                 String sku = scanner.nextLine().trim();

                 System.out.println("Enter the name of the product: ");
                 String name = scanner.nextLine().trim();

                 System.out.println("Enter the category of the product: ");
                 String category = scanner.nextLine().trim().toUpperCase();

                 System.out.println("Enter the quantity of the product: ");
                 int qty = Integer.parseInt(scanner.nextLine().trim());

                 System.out.println("Enter the price of the product: ");
                 double price = Double.parseDouble(scanner.nextLine().trim());

                 Category cat = Category.valueOf(category);
                 Product product = new Product(sku, name, qty, price, cat);
                 inventory.add(product);

             } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
             } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
             }

         } else if (command.equals("remove")) {
             try {
                 System.out.println("Enter SKU to remove: ");
                 String sku = scanner.nextLine().trim();
                 inventory.remove(sku);
                 System.out.println("Product removed successfully.");
             } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
             }

        } else if (command.equals("adjust")) {
             try {
                 System.out.println("Enter SKU: ");
                 String sku = scanner.nextLine().trim();

                 System.out.println("Enter delta (e.g. 5 or -3): ");
                 String deltaInput = scanner.nextLine().trim();
                 int delta = Integer.parseInt(deltaInput);
                 inventory.adjustQty(sku, delta);
                 System.out.println("Quantity adjusted successfully.");
             } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
             } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
             }


        } else if (command.equals("find")) {
             try {
                 System.out.println("Enter category (e.g ELECTRONICS/FOOD etc).");
                 String category = scanner.nextLine().trim().toUpperCase();
                 Category cat = Category.valueOf(category);
                 for (Product p : inventory.findByCategory(cat)) {
                     System.out.println(p);
                 }
             } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
             }

        } else {
            System.out.println("Invalid command.");
        }
      }
   }
}
