package app;

public class Main {

    public static void main(String[] args) {
        Inventory inv = new Inventory();

        Product p1 = new Product("SKU001", "Widget", 10, 2.99);
        Product p2 = new Product("SKU002", "Gadget", 0, 9.99);
        Product p3 = new Product("SKU003", "Thingamajig", 5, 1.49);

        inv.add(p1);
        inv.add(p2);
        inv.add(p3);

        System.out.println("All products:");
        for (Product p : inv.listAll()) {
            System.out.println(p);
        }

        inv.adjustQty("SKU001", -3);
        System.out.println("\nUpdated SKU001:");
        System.out.println(inv.getBySku("SKU001"));

        inv.remove("SKU002");
        System.out.println("\nAfter removing SKU002:");
        for (Product p : inv.listAll()) {
            System.out.println(p);
        }

        try {
            inv.remove("MISSING-SKU");
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught expected error: " + e.getMessage());
        }
    }

}
