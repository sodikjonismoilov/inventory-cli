package app;

import java.util.*;

public class Inventory {

    private final Map<String, Product> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void add(Product p) {
        if (p == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (items.containsKey(p.getSku())) {
            throw new IllegalArgumentException("Product with SKU " + p.getSku() + " already exists");
        }
        items.put(p.getSku(), p);

    }

    public Product getBySku(String sku) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be null or empty");
        }
        return items.get(sku);
    }

    public void remove(String sku) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be null or empty");
        }
        if (!items.containsKey(sku)) {
            throw new IllegalArgumentException("With that sku does not exist");
        }
        items.remove(sku);
    }

    public Collection<Product> findByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }

        List<Product> results = new ArrayList<>();
        for (Product p : items.values()) {
            if (p.getCategory() == category) {
                results.add(p);
            }

        }
        return results;

    }
    public void adjustQty(String sku, int delta) {
        if (sku == null || sku.trim().isEmpty()){
            throw new IllegalArgumentException("SKU cannot be null or empty");
        }
       Product p = items.get(sku);
        if (p == null) {
            throw new IllegalArgumentException("With that sku does not exist");
        }
        p.adjustQty(delta);
    }

    public Collection<Product> listAll() {
        List<Product> results = new ArrayList<>();
        results.addAll(items.values());
        return results;
    }
}


