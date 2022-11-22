package Oracle;

import java.util.Scanner;

public class ShortestUnshortedarray {
	
	public static boolean inc(int a[])
	{
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]>=a[i+1])
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean dec(int a[])
	{
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]<=a[i+1])
			{
				return false;
			}
		}
		return true;
	}
    public static int sorted(int a[])
    {
    	if(inc(a)==true||dec(a)==true)
    	{
    		return 0;
    	}
    	else
    		return 3;
    }
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		  int t=sc.nextInt();
		  while(t-->0)
		  {
		     int a=sc.nextInt();
		     int arr[]=new int[a]; 
		     for(int i=0;i<a;i++)
		     {
		         arr[i]=sc.nextInt();
		     }
		     int a1=sorted(arr);
		     System.out.println(a1);
		  }
	}

}
