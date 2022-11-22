package stackandrelatedquestions;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
//Nearest greater to left
public class StockSpanProblem {
	
	class Pair{
		Integer index;
		Integer value;
		public Pair(Integer index, Integer value)
		{
			this.index = index;
			this.value = value;
		}
		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		
	}
	
	public static void printStokcSpan(int a[], StockSpanProblem A)
	{
		Stack<Pair>  s = new Stack<>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		//s.push(-1);
		for(int i = 0; i < a.length; i++)
		{
			if(s.size() == 0)
			{
				list.add(-1);
			}
			else if(s.size() > 0 && s.peek().value > a[i])
			{
				list.add(s.peek().index);
			}
			else if(s.size() > 0 && s.peek().value <= a[i])
			{
				while(s.size() > 0 && s.peek().value <= a[i])
				{
					s.pop();
				}
				if(s.size() == 0)
				{
					list.add(-1);
				}
				else
				{
					list.add(s.peek().index);
				}
			}
			//System.out.println(s.peek().value);
			s.push(A.new Pair(i, a[i]));
			
		}
		//System.out.println(s.peek().value);
		//System.out.println(list);
		//System.out.println(list.size());
		System.out.println(list);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++)
		{
			//System.out.println(list.get(i));
			res.add(i - list.get(i));
		}
		int i = 0;
		//System.out.println(list);
		//Collections.reverse(list);
		while(i < a.length)
		{
			System.out.println("Next Greater element of "+ a[i]+ "--- "+ res.get(i));
			i++;
		}
	}
	
	public static void main(String []args) {
		
		int a [] = {100, 80, 60, 70, 60, 75, 85};
		printStokcSpan(a, new StockSpanProblem());
		
		
		
		
	}

}
