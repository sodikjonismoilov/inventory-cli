package app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Inventory {

    private Map<String, Product> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void add(Product p) {
        if (items.containsKey(p.getSku())) {
            throw new IllegalArgumentException("Product with SKU " + p.getSku() + " already exists");
        }
        items.put(p.getSku(), p);
    }

    public Product getBySku(String sku){
        return items.get(sku);
    }
    public void remove(String sku) {
        if (!items.containsKey(sku)){
            throw new IllegalArgumentException("Item with SKU " + sku + " not found.");
        }
        items.remove(sku);
    }

    public void adjustQty(String sku, int delta) {
        if (!items.containsKey(sku)) {
            throw new IllegalArgumentException("Product with SKU " + sku + " not found"
            );
        }
        items.get(sku).adjustQty(delta);
    }

    public Collection<Product> listAll() {
        return items.values();
    }

}
