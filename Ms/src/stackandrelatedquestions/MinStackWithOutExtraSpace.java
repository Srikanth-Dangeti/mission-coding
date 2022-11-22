package stackandrelatedquestions;

import java.util.Stack;

public class MinStackWithOutExtraSpace {
	
	static Stack<Integer> s = new Stack<Integer>();
	static int MinElem = Integer.MAX_VALUE;
	
	public static void push(int curr)
	{
		if(s.size() == 0)
		{
			s.push(curr);
			MinElem = curr;
			
		}
		else
		{
			if(curr >= MinElem)
			{
				s.push(curr);
			}
			else
			{
				s.push(2 * curr -MinElem);
				MinElem = curr;
			}
		}
		
	}
	
	public static void pop()
	{
		if(s.size() == 0)
			return ;
		else
		{
			if(s.peek() >= MinElem)
				s.pop();
			else if(s.peek() < MinElem)
			{
				MinElem = 2 * MinElem - s.peek();
				s.pop();
			}
		}
	}
	
	public static int top()
	{
		if(s.size() == 0)
			return -1;
		else 
		{
			if(s.peek() >= MinElem)
			{
				return s.peek();
			}
			else
			{
				return MinElem;
			}
		}
	}
	
	public static int getMinStack()
	{
		if(s.size() == -1)
			return -1;
		return MinElem;
	}
	
	public static void main(String []args)
	{
		push(18);
		push(19);
		System.out.println("Minimum curr in the stack ="+ getMinStack());
		push(29);
		push(15);
		System.out.println("Minimum curr in the stack ="+ getMinStack());
		pop();
		System.out.println("Top Element = "+top());
		System.out.println("Minimum curr in the stack ="+ getMinStack());
		
	}

}
