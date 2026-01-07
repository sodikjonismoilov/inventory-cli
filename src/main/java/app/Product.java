package app;

public class Product {

    private String sku;
    private String name;
    private int qty;
    private double price;
    private Category category;

    public Product(String sku, String name, int qty, double price, Category category){


        if(sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU number cannot be empty.");
        }

        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null");
        }


      if (qty < 0) {
              throw new IllegalArgumentException("Invalid quantity: must be non-negative.");
          }

        if (price < 0){
            throw new IllegalArgumentException("Invalid price number.");
        }

        if (category == null){
            throw new IllegalArgumentException("Category cannot be null.");
        }

        this.sku = sku;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.category = category;
    }

    public void adjustQty(int delta) {
        if (this.qty + delta < 0) {
            throw new IllegalArgumentException(
                    "Invalid adjustment: Current quantity: " + this.qty + " cannot subtract "  + Math.abs(delta));
        }
        this.qty += delta;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

 @Override
 public String toString() {
        return String.format("%s | %s | %d | %.2f | %s", sku, name, qty, price, category);
 }

}
