package app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Inventory {

    private final Map<String, Product> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void add(Product p) {
        if (p == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (p.getSku() == null || p.getSku().trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be empty");
        }
        if (items.containsKey(p.getSku())) {
            throw new IllegalArgumentException("Product with SKU " + p.getSku() + " already exists");
        }
        items.put(p.getSku(), p);
    }

    public Product getBySku(String sku){
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be empty");
        }
        return items.get(sku);
    }
    public void remove(String sku) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be empty");
        }
        if (!items.containsKey(sku)){
            throw new IllegalArgumentException("Item with SKU " + sku + " not found.");
        }
        items.remove(sku);
    }

    public void adjustQty(String sku, int delta) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be empty");
        }
        Product product = items.get(sku);
        if (product == null) {
            throw new IllegalArgumentException("Product with SKU " + sku + " not found");
        }
        product.adjustQty(delta);
    }

    public Collection<Product> listAll() {
        return items.values();
    }

}
