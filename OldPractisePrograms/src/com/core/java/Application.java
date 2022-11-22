package com.core.java;
import java.util.Scanner;
public class Application {

    public static void main( String [] args) { 
        Scanner input = new Scanner(System.in);
        ShoppingList myList = new ShoppingList();
        int userOpt = 0;
        while (userOpt != 3) {
            System.out.println("");
            System.out.println("----- Shopping List------");
            System.out.println("(1) Add an item to the list. ");
            System.out.println("(2) Display list and total number of items. ");
            System.out.println("(3) Exit. ");
            userOpt = input.nextInt();  

            if (userOpt == 1) {
            myList.addItem();

            }

            if (userOpt == 2) {
            myList.displayItem();
            }
        }
    }
}