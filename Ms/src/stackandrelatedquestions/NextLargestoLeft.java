package stackandrelatedquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Next Greate to Left
public class NextLargestoLeft {
	
	public static void printNGE(int a[])
	{
		Stack<Integer>  s = new Stack<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		//s.push(-1);
		for(int i = 0; i < a.length; i++)
		{
			if(s.size() == 0)
			{
				list.add(-1);
			}
			else if(s.size() > 0 && s.peek() > a[i])
			{
				list.add(s.peek());
			}
			else if(s.size() > 0 && s.peek() <= a[i])
			{
				while(s.size() > 0 && s.peek() <= a[i])
				{
					s.pop();
				}
				if(s.size() == 0)
				{
					list.add(-1);
				}
				else
				{
					list.add(s.peek());
				}
			}
			//list.set
			//list.con
			s.push(a[i]);
			
		}
		int i = 0;
		//Collections.reverse(list);
		while(i < a.length)
		{
			System.out.println("Next Greater element of "+ a[i]+ "--- "+ list.get(i));
			i++;
		}
	}
	
	public static void main(String []args)
	{
		int a[] = {11, 13, 21, 3};
		printNGE(a);
	}

}
