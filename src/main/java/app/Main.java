package app;

public class Main {

    public static void main(String[] args) {
       Inventory inv = new Inventory();

       AdminCli cli = new AdminCli(inv);
       cli.run();
    }

}
