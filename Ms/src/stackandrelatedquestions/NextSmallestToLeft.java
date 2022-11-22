package stackandrelatedquestions;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallestToLeft {
	
	public static void printNSL(int a[])
	{
		Stack<Integer>  s = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		//s.push(-1);
		for(int i = 0; i < a.length; i++)
		{
			if(s.size() == 0)
			{
				list.add(-1);
			}
			else if(s.size() > 0 && s.peek() < a[i])
			{
				list.add(s.peek());
			}
			else if(s.size() > 0 && s.peek() >= a[i])
			{
				while(s.size() > 0 && s.peek() >= a[i])
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
			
			s.push(a[i]);
			
		}
		int i = 0;
		//Collections.reverse(list);
		System.out.println(list);
		while(i < a.length)
		{
			System.out.println("Next smallest element of to Left"+ a[i]+ "--- "+ list.get(i));
			i++;
		}
	}
	
	public static void main(String []args)
	{
		//int a[] = {4, 5, 2, 10, 8};
		int a[] = {6,2,5,4,5,1,6};
		
		printNSL(a);
	}

}
