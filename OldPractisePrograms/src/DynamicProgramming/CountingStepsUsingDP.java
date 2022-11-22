package DynamicProgramming;

import java.util.Scanner;

public class CountingStepsUsingDP {
	public static int countWays(int n) 
    { 
        int[] res = new int[n + 1]; 
        res[0] = 1; 
        res[1] = 1; 
        //res[2] = 2; 
  
        for (int i = 2; i <= n; i++) 
            res[i] = res[i - 1] + res[i - 2] ;
                               // + res[i - 3]; 
  
        return res[n]; 
    } 
  
    // Driver function 
    public static void main(String argc[]) 
    { 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
    	
        System.out.println(countWays(n)); 
    } 

}
