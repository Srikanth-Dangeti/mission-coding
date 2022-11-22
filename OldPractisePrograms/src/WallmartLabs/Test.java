package WallmartLabs;

import javax.crypto.spec.PSource;

//User1 : it’s afternonn 3.00am 
//Uer2: abc  huihn.
//UYse





public class Test {
	
	/*a[][];
	
	a[i+1][j+2],a[i-1][j+2]
			
			a[i+2][j+1]
		    a[i+2][j-1]*/
	
	
	public static void sourceToDestination(int a[][])
	{
		int m = a.length;
		int n= a[0].length;
		
		System.out.println(sourceToDestinationUtil(0,0,a,3,4));
		
		
	}
	
	
	public static int sourceToDestinationUtil(int i, int j, int a[][], int ides, int jdes)
	{
		
		//System.out.println("i = "+i);
		//System.out.println("j = "+j);
		if(i< 0 || j<0 || i >= a.length || j >= a[0].length)
		{
			return -1;
		}
		
		if(i == ides && j == jdes)
		{
			a[i][j] = a[i][j]+1;
			return a[ides][jdes];
		}
		
		
		if(a[i][j] != 0)
			a[i][j] = a[i][j]+1;
		else
			a[i][j] = 1;
		
		sourceToDestinationUtil(i+1,j+2,a,ides,jdes);
		sourceToDestinationUtil(i-1,j+2,a,ides,jdes);
		sourceToDestinationUtil(i+2,j+1,a,ides,jdes);
		sourceToDestinationUtil(i+2,j-1,a,ides,jdes);
		
		
		
		return a[ides][jdes];
	}
	
	public static void main(String []args)
	{
		String str = "its afternoon";
		String str1 [] = str.split(" ");
		System.out.println(str1[0]);
		System.out.println(str1[1]);
		int a[][] = new int[8][8];
		sourceToDestination(a);
	}

}
