import java.util.Arrays;
import java.util.Scanner;
	

public class ReverseAwordInaString 
{
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String to Be Reversed");
		String str=sc.nextLine();
		reverseWord(str);
	}
	public static void reverseWord(String a)
	{
		System.out.println(a);
	  String str[]=a.split(".");
	  String res[]=new String[str.length];
	  int k=0;
	  for(int i=str.length-1;i>=0;i--)
	  {
		  
		  res[k]=str[i];
		  k++;
		  
	  }
	  for(int i=0;i<res.length;i++)
	  {
	      System.out.print(res[i]);
	      System.out.print(" ");
	  }
	  System.out.println(Arrays.toString(res));
	}

}
