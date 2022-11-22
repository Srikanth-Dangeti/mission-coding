package Alltrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



class DiagonalTraversal
{
    static Node root;
    
    public DiagonalTraversal()
    {
        root=null;
    }
    
    static void diagonalPrintUtil(Node root,int d, HashMap<Integer,ArrayList<Integer>> diagonalPrint)
    { 
          
         // Base case 
        if (root == null) 
            return; 
          
        // get the list at the particular d value 
        ArrayList<Integer> k = diagonalPrint.get(d); 
          
        // k is null then create a vector and store the data 
        if (k == null) 
        { 
            k = new ArrayList<>(); 
            k.add(root.data); 
        } 
          
        // k is not null then update the list 
        else
        {   
            k.add(root.data); 
        } 
          
        // Store all nodes of same line together as a vector 
        diagonalPrint.put(d,k); 
          
        // Increase the vertical distance if left child 
        diagonalPrintUtil(root.left, d + 1, diagonalPrint); 
           
        // Vertical distance remains same for right child 
        diagonalPrintUtil(root.right, d, diagonalPrint); 
    } 
      
    // Print diagonal traversal of given binary tree 
    static void diagonalPrint(Node root) 
    { 
        // create a map of vectors to store Diagonal elements 
        HashMap<Integer,ArrayList<Integer>> diagonalPrint = new HashMap<>(); 
        diagonalPrintUtil(root, 0, diagonalPrint); 
          
        System.out.println("Diagonal Traversal of Binnary Tree"); 
        Set <Entry<Integer, ArrayList<Integer>>> set = diagonalPrint.entrySet();
        
        Iterator<Entry<Integer, ArrayList<Integer>>> itr = set.iterator();
        while(itr.hasNext())
        {   Map.Entry<Integer, ArrayList<Integer>> n = itr.next();
            System.out.println(n);
            System.out.println(n.getValue()); 
        } 
    }
    
    public static void main(String[] args) 
    {
      
        //DiagonalTraversal tree=new DiagonalTraversal();
        root = new Node(8); 
        root.left = new Node(3); 
        root.right = new Node(10); 
        root.left.left = new Node(1); 
        root.left.right = new Node(6); 
        root.right.right = new Node(14); 
        root.right.right.left = new Node(13); 
        root.left.right.left = new Node(4); 
        root.left.right.right = new Node(7); 

        diagonalPrint(root); 

    }
}