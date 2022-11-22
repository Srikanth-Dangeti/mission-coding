package stackandrelatedquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//Nearest Greater to righ
public class NextLargestToRight {

	public static void printNGE(int a[])
	{
		Stack<Integer>  s = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		//s.push(-1);
		for(int i = a.length-1; i >= 0; i--)
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
			//System.out.println(s);
			s.push(a[i]);
			
		}
		
		int i = a.length -1;
		Collections.reverse(list);
		
		while(i >= 0)
		{
			System.out.println("Next Greater element of "+ a[i]+ "--- "+ list.get(i));
			i--;
		}
	}
	
	public static void main(String []args)
	{
		int a[] = {11, 13, 21, 3};
		printNGE(a);
	}
}
