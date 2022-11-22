package com.core.java;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {

    ArrayList<ShoppingItem> list = new ArrayList<ShoppingItem>();
    //Add a new ShoppingItem to the list
         public void addItem()
    { 
            System.out.println();
            System.out.println("enter in the name of your item");
            Scanner keyboard = new Scanner(System.in);
            String ItemName = keyboard.nextLine();

            System.out.println("enter in the price of your item");
            double ItemPrice = keyboard.nextDouble();

            System.out.println("enter in the Qty of your item");
            int ItemQty = keyboard.nextInt();

            ShoppingItem Item = new ShoppingItem(ItemName, ItemPrice,
                        ItemQty);
            list.add(Item);
            System.out.println("Item Added");
    }

    //Display list and total number of items. 
         public void displayItem(){
             System.out.println( list.size()+ " items. ");
                for (ShoppingItem x : list) {
                    System.out.println(x.toString());
                }

                 }



 }