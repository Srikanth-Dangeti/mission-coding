package stackandrelatedquestions;

import java.util.*;

public class MinStackWithExtraSpace {
	
	static Stack<Integer> s = new Stack<Integer>();
	static Stack<Integer> ss = new Stack<Integer>();
	
	public static void push(int item)
	{
		s.push(item);
		
		if(ss.size() == 0 || item <= ss.peek())
		{
			ss.push(item);
		}
	}
	
	public static int pop()
	{
		if(s.size() == 0)
			return -1;
		
		int ans = s.peek();
		s.pop();
		if(ss.peek() == ans)
		{
			ss.pop();
		}
		
		return ans;
		
	}
	
	public static int getMinStack()
	{
		if(ss.size() == 0)
			return -1;
		
		return ss.peek();
	}
	
	public static void main(String [] args)
	{
		push(18);
		push(19);
		System.out.println("Minimum item in the stack ="+ getMinStack());
		push(29);
		push(15);
		System.out.println("Minimum item in the stack ="+ getMinStack());
		pop();
		System.out.println("Minimum item in the stack ="+ getMinStack());
		
	}

}
