package store_day1;

import java.io.*;
import java.util.*;

public class Cart {
    protected ArrayList<String> cart;

    public Cart(){
        cart = new ArrayList<String>();
    }
    
    public ArrayList<String> getCart(){
        return cart;
    }


    public void itemList(){

        int cartLength = this.cart.size();

        if(cartLength == 0){ System.out.println("Your cart is empthy");}
        else{
        for(int idx = 0 ; idx< cartLength; idx++){
            
            System.out.printf("%d. %s\n",idx+1, this.cart.get(idx));

            }
        }

    }

    public void createCart(String item){
        if(!this.cart.contains(item)){
            this.cart.add(item);
        }
    }
    public void addItem(String item){
        if(!this.cart.contains(item)){
            System.out.printf("%s added to cart \n",item);
            this.cart.add(item);
        }else if(this.cart.contains(item)){
            System.out.printf("You have %s in your cart \n",item);
        }
    }

    public void removeItem(int pos){
        if(pos < this.cart.size()){
            System.out.printf("%s removed from cart \n",this.cart.get(pos - 1));
            this.cart.remove(pos - 1);}
        else{
            System.out.println("Incorrect item index\n");
        }

    }
    
}

