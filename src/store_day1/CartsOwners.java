package store_day1;

import java.io.*;
import java.util.*;


public class CartsOwners {
    protected HashMap<String,Cart> carts;
    protected String currentLogin;

    public CartsOwners(){
        carts = new HashMap<String,Cart>();
        currentLogin = null;
    }
    //ADD
    public void addItems(String item){
        Cart userCart = this.carts.get(currentLogin);
        userCart.addItem(item);
    }
    
    //LIST
    public void getCart(){
        Cart userCart = this.carts.get(currentLogin);
        userCart.itemList();
    }

    //DELETE

    public void deleteItem(int idx){
        Cart userCart = this.carts.get(currentLogin);
        userCart.removeItem(idx);
    }
    //USERS
    public void getUsersName(){
        System.out.println("The following users are registered");
        int counter = 1;
        for(String name: carts.keySet()){
            System.out.printf("%d. %s\n",counter,name);
            counter++;
        }
    }

    //LOGIN
    public void loginUser(String name){
        try{
            Cart userCart = new Cart();
            String fileName = "cartdb/" + name + ".db";
            int counter = 1;
            File file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
                System.out.printf("%s, your cart is empty\n",name);
            }
            else{
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                bufferedReader.readLine();
                String item = bufferedReader.readLine();
                if (item == null){
                    System.out.printf("%s, your cart is empty\n",name);
                }
                else{
                    System.out.printf("%s, your cart contains the following items\n",name);
                    while(item != null){
                        System.out.printf("%d. %s\n",counter,item);   
                        item = bufferedReader.readLine();
                        userCart.createCart(item);
                        counter++;
                    }
                }
                bufferedReader.close();
                reader.close();
            }

            this.carts.put(name,userCart);
            this.currentLogin = name;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    //SAVE
    public void saveUser(){
        try{
            String name = currentLogin;
            Cart nameCart = this.carts.get(name);
            String fileName = "cartdb/" + name + ".db";
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(fileName + "\n");
            for(String item: nameCart.getCart()){
                //System.out.printf("Item to be in the file: %s",item);
                bufferedWriter.write(item + "\n");
            }
            System.out.println("Your cart has been saved\n");
            bufferedWriter.flush();
            writer.flush();
            bufferedWriter.close();
            writer.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
