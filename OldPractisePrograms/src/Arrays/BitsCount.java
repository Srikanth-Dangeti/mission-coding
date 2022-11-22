package Arrays;

import java.util.Scanner;

public class BitsCount {
	
	public static int FlippedCount(int a,int b)
	{
		int n=a^b;
		int count = 0;
        while (n != 0) {
            
        	 n =n & (n - 1) ;
             count++;
        }
        return count;
		
	}
	
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the 2 fucking Numbers");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(FlippedCount(a,b));
		System.out.println(Integer.toBinaryString(a));
		
	}

}
