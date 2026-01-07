package app;

public class Box {
    private int size;

    public Box(int size) {

        if (size < 0) {
            throw new IllegalArgumentException("Invalid size, size cannot be negative.");
        }
        this.size = size;
    }

    public void grow(int amount){

       if (amount < 0) {
           throw new IllegalArgumentException("Invalid size, amount cannot be negative.");
       }
       this.size += amount;
    }

    public int getSize() {
        return size;
    }
}
