package store_day1;

import java.io.Console;

public class Main {
    public static void main(String[] args) throws NullPointerException {
        System.out.println("Welcome to your shopping cart");
        Console cons = System.console();
        Cart cart = new Cart();

        while(true){
            String cmd = cons.readLine("CMD>>>> ").trim();
            String transformed = cmd.replaceAll("\\p{Punct}","");
            String[] input= transformed.split(" ");

            switch (input[0].toLowerCase()) {
                case "list":
                    cart.itemList();
                    break;

                case "brk":
                    System.exit(0);
                    break;

                case "add":
                    for(int idx = 1; idx<input.length;idx++){
                        cart.addItem(input[idx]);
                    }
                    break;

                case "delete":
                    int pos = Integer.parseInt(input[1]);
                    cart.removeItem(pos);
                    break;

                default:
                    break;
            }
        }
        
    }
}
