package store_day1;

import java.io.Console;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NullPointerException, IOException{
        System.out.println("Welcome to your shopping cart");
        Console cons = System.console();
        CartsOwners cartOwners = new CartsOwners();

        while(true){
            String cmd = cons.readLine("CMD>>>> ").trim();
            String transformed = cmd.replaceAll("\\p{Punct}","");
            String[] input= transformed.split(" ");
            String command = input[0];
            
            if (Constants.LOGIN.equals(command)){
                if(input.length > 1){
                    String name = input[1];
                    cartOwners.loginUser(name);
                }
            }else if(Constants.BREAK.equals(command)){
                System.exit(0);
            }
            else if(Constants.ADD.equals(command)){
                for(int idx = 1 ; idx < input.length ; idx++){
                    cartOwners.addItems(input[idx]);
                }
            }
            else if(Constants.LIST.equals(command)){
                cartOwners.getCart();
            }
            else if(Constants.DELETE.equals(command)){
                String pos = input[1];
                cartOwners.deleteItem(Integer.parseInt(pos));

            }
            else if(Constants.USERS.equals(command)){
                cartOwners.getUsersName();
            }
            else if(Constants.SAVE.equals(command)){
                cartOwners.saveUser();
            }
        }
        
    }
}
