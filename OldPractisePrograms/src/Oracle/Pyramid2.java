package Oracle;

import java.util.Scanner;

public class Pyramid2 {
	
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		 
	    System.out.println("How Many Rows You Want In Your Pyramid?");
	
	    int noOfRows = sc.nextInt();
	    int rowCount = 1;
	    System.out.println(1<<4);
	    System.out.println(Integer.toBinaryString(60));
	    /*for(int i=noOfRows;i>0;i--)
	    {
	    	for(int j=1;j<=i;j++)
	    	{
	    		System.out.print(" ");
	    	}
	    	
	    	for(int j=1;j<=rowCount;j++)
	    	{
	    		System.out.print(j+" ");
	    	}
	    	
	    	rowCount++;
	    	System.out.println();
	    	
	    }*/
	}

}
