package reucrsion;

import java.util.ArrayList;

public class GenerateParenthesis {
	
	
	public static void slove(int open, int close, String op, ArrayList list)
	{
		System.out.println(open);
		System.out.println(close);
		System.out.println("op = "+op);
		if(open == 0 && close ==0)
		{
			//System.out.print(op);
			list.add(op);
			//System.out.println();
			return ;
		}
		
		if(open!=0)
		{
			String op1 = op;
			if(op1.length()==0)
				op1="(";
			else
			op1 = op1+"(";
			System.out.println("op1 = "+op1);
			slove(open-1, close, op1, list);
		}
		
		if(close>open)
		{
			String op2=op;
			System.out.println("before "+op2);
			if(op2.length()==0)
				op2 =")";
			else {
			 //op2.concat(")");
				op2= op2+")";
			}
			System.out.println("op2 = "+op2);
			slove(open, close-1, op2, list);
		}
		
		return ;
		
	}
	public static void main(String [] args)
	{
		int open = 2;
		int close = 2;
		ArrayList<String> list = new ArrayList<>();
		String op ="";
		slove(3,3,op,list);
		System.out.println(list);
	}

}
