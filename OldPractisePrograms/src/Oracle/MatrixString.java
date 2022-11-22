package Oracle;

import java.util.Scanner;

public class MatrixString {
	
	public static void stringSearch(char[][]ch,String str)
	{
		
		String res="";
		boolean flag=false;
		for(int i=0;i<ch.length;i++)
		{
			res="";
			for(int j=0;j<ch[0].length;j++)
			{
				
				if(str.indexOf(ch[i][j])!=-1)
				{
					res=res+ch[i][j];
				}
				String temp=res;
				StringBuffer sb=new StringBuffer(temp);
				sb.reverse();
				temp=sb.toString();
				//System.out.println(res);
				//System.out.println(temp);
				if(res.length()==str.length()&&(res.equalsIgnoreCase(str)||temp.equalsIgnoreCase(str)))
				{
					flag=true;
					System.out.println("Pattern Found at starting Index"+"("+i+","+(j-(str.length()-1))+")"+"End"+ "("+i+","+j+")");
					System.out.println("First");
					break;
					
				}
				
			}
			if(flag==true)
			{
				break;
			}
			
		}
		if(flag!=true)
		{
			for(int i=0;i<ch[0].length;i++)
			{
				res="";
				for(int j=0;j<ch.length;j++)
				{
					
					if(str.indexOf(ch[j][i])!=-1)
					{
						res=res+ch[j][i];
					}
					String temp=res;
					StringBuffer sb=new StringBuffer(temp);
					sb.reverse();
					temp=sb.toString();
					if(res.length()==str.length()&&(res.equalsIgnoreCase(str)||temp.equalsIgnoreCase(str)))
					{
						flag=true;
						System.out.println("Pattern Found at starting Index"+"("+i+","+(j-(str.length()-1))+")"+"End"+ "("+i+","+j+")");
						System.out.println("SECOND");	
						break;
						
					}
					
					
				}
				
			}
		}
		if(flag!=true)
		{
			for(int i=0;i<ch.length;i++)
			{
				res="";
				for(int j=0;j<ch[0].length;j++)
				{
					
					if(str.indexOf(ch[j][j])!=-1)
					{
						res=res+ch[j][j];
					}
					String temp=res;
					StringBuffer sb=new StringBuffer(temp);
					sb.reverse();
					temp=sb.toString();
					if(res.length()==str.length()&&(res.equalsIgnoreCase(str)||temp.equalsIgnoreCase(str)))
					{
						
						flag=true;
						System.out.println("Pattern Found at starting Index"+"("+i+","+(j-(str.length()-1))+")"+"End"+ "("+i+","+j+")");
						System.out.println("3RD");
						break;
						
					}
					
					
				}
				
			}
		}
		
		
		if(flag)
		System.out.println("String Found");
		else
	    System.out.println("String Not Found");
	}
	
	public static void  main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		char [][]ch= {
				{'a','b','c','d'},
				{'q','t','w','g'},
				{'k','r','z','l'},
				{'x','y','m','n'}};
		System.out.println("Enter the String");
		String input=sc.next();
		stringSearch(ch,input);
	}

}
