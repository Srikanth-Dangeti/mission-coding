package StringPrg;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FirstNonrepeative {
	
	
	static void firstNonrepettive(String str)
	{
		char [] ch=str.toCharArray();
		HashMap<Character,Integer> h=new HashMap<Character,Integer>();
		for (int i=0;i<ch.length;i++)
		{
			if(h.containsKey(ch[i]))
			{
				h.put(ch[i],h.get(ch[i])+1);
			}
			else
				h.put(ch[i],1);
			
		}
		
		int count=0;
		for(int i=0;i<ch.length;i++)
		{
			if(h.get(ch[i])==1&&count!=1)
			{
				System.out.println(ch[i]);
				count++;
				
			}
		}
		
		
		
	}
	
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Fucking String");
		String str=sc.nextLine();
		firstNonrepettive(str);
		
		
	}
}
