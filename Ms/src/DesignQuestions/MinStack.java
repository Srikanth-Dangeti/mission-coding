package DesignQuestions;

public class MinStack {

	StackNode top;
	
	public void push(int k)
	{
		if(top==null)
		{
			top=new StackNode(k);
		}
		else
		{
			StackNode temp=new StackNode(k);
			temp.next=top;
			temp.min=Math.min(top.min, k);
			top=temp;
		}
	}
	
	public void pop()
	{
		if(top==null)
		{
			System.out.println("Stack is Empty");
			return ;
		}
		top=top.next;
			
	}
	
	public int top()
	{
		if(top==null)
		{
			System.out.println("Stack is Empty");
			return Integer.MAX_VALUE;
			
		}
		return top.value;
	}
	
	public int getMin()
	{
		if(top==null)
		{
			System.out.println("Stack is Empty");
			return Integer.MIN_VALUE;
		}
		return top.min;
	}
	
	public static void main(String args[])
	{
		MinStack mStack = new MinStack();
		mStack.push(7);
		mStack.push(8);
		System.out.println(mStack.getMin());
		mStack.push(5);
		mStack.push(9);
		System.out.println(mStack.getMin());
		mStack.push(5);
		mStack.push(2);
		System.out.println(mStack.getMin());
		mStack.pop();
		mStack.pop();
		System.out.println(mStack.getMin());
	}
}
