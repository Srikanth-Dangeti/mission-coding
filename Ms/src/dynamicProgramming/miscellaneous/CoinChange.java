
package dynamicProgramming.miscellaneous;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	
	public static int coinChangeRecursion(int n,int size,int coin[])
	{	
		System.out.println(size);
		System.out.println(n);
		if(n==0)
		  return 1;
		
		if(n<0)
			return 0;
		if(size<=0 && n>=1)
		{
			return 0;
		}
		
		return coinChangeRecursion(n, size-1, coin)+coinChangeRecursion(n-coin[size-1], size, coin);
		
	}
	
	public static long countWaysDynamic(int S[], int m, int sum) 
    { 
        
        long[] table = new long[sum+1]; 
  
        // Initialize all table values as 0 
        Arrays.fill(table, 0);   //O(n) 
  
        // Base case (If given value is 0) 
        table[0] = 1; 
  
        for (int i=0; i<m; i++) 
            for (int j=S[i]; j<=sum; j++) 
                table[j] += table[j-S[i]]; 
  
        return table[sum];
	}
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the sum");
		int sum=sc.nextInt();
		
		int coin[]= {1,2,5};
		//System.out.println("No of ways of Coin Change is Using Recursion");
		//System.out.println(coinChangeRecursion(sum, coin.length, coin));
		System.out.println("No of ways Coin Change is using Dynamic Programming");
		System.out.println(countWaysDynamic(coin, coin.length, sum));
		
	}

}
