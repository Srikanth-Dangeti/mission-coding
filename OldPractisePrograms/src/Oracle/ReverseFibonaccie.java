package Oracle;

import java.util.Scanner;

public class ReverseFibonaccie {
	
	public static int f(int n){
	    if (n <= 1)
	        return n;
	    else 
	        return f(n-1) + f(n-2);
	}
	static void printReversedFib(int x){
	    if(x <= 1)
	        System.out.println(f(x));
	    else{
	        System.out.println(f(x));
	        printReversedFib(x-1);
	    }
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a fucking number");
		int n=sc.nextInt();
		printReversedFib(n);
		
	}

}
