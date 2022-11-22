package Others;

import java.util.Stack;

public class ValidParentheses {

	public static boolean isMatchingPair(char character1, char character2) 
	{
		//System.out.println(character1+"test "+character2);
		if(character1=='('&&character2==')')
		{
			return true;
		}
		else if(character1=='{'&&character2=='}')
		{
			return true;
		}
		else if (character1 == '[' && character2 == ']') 
	         return true; 
	       else
	         return false; 
	}
	public static boolean areParenthesisBalanced(char exp[])
	{
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<exp.length;i++)
		{
			if(exp[i]=='{' ||exp[i]=='('||exp[i]=='[')
			{
				s.push(exp[i]);
			}
			if(exp[i]=='}' ||exp[i]==')'||exp[i]==']')
			{
				if(s.isEmpty())
				{
					return false;
					
				}
				else if (!isMatchingPair(s.pop(), exp[i]) ) 
				     { 
				       return false; 
				     } 
			}
		}
		 if (s.isEmpty()) 
	         return true; 
	       else
	         {  
	             return false; 
	         }
		
		
		
	}
	public static void main(String []args)
	{
		String str="{[]}";
		char exp[]=str.toCharArray();
		if (areParenthesisBalanced(exp)) 
	          System.out.println("balanced"); 
	        else
	          System.out.println("not balanced"); 
	}
}
