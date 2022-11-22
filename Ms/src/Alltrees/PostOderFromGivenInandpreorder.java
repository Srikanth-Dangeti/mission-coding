package Alltrees;

import java.util.HashMap;

public class PostOderFromGivenInandpreorder {
    static int preIndex = 0;  
    
    void printPost(int[] in, int[] pre, int inStrt, int inEnd, HashMap<Integer, Integer> hm)  
    {  
        if (inStrt > inEnd)  
            return;          
  
        int inIndex = hm.get(pre[preIndex++]);  
        //traversing the left first
        printPost(in, pre, inStrt, inIndex - 1, hm);  
        //traversing the right
        printPost(in, pre, inIndex + 1, inEnd, hm);  
  
        System.out.print(in[inIndex] + " ");  
    }  
  
    void printPostMain(int[] in, int[] pre)  
    { 
        int n = pre.length; 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
        for (int i=0; i<n; i++) 
           hm.put(in[i], i); 
             
        printPost(in, pre, 0, n-1, hm); 
    } 
    
	public static void main(String []ards) 	
	{
		
		int in[] = { 4, 2, 5, 1, 3, 6 };  
        int pre[] = { 1, 2, 4, 5, 3, 6 };  
        PostOderFromGivenInandpreorder tree = new PostOderFromGivenInandpreorder();  
        tree.printPostMain(in, pre);  
    
	}

}
