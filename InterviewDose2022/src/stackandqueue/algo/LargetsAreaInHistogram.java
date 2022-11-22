package stackandqueue.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LargetsAreaInHistogram {
    
    class Pair{

        Integer index;
        Integer value;
    
        public Pair(Integer index, Integer value)
        {
            this.index = index; 
            this.value = value;
        }
    
        public Integer getIndex()
        {
            return index;
        }
    
        public void setIndex(Integer index)
        {
            this.index = index;
        }
    
        public Integer getValue()
        {
            return value;
        }
    
        public void setValue(Integer value)
        {
            this.value = value;
        }
    
    
    }

    public int getMAH(int a[])
    {
        //Nearest element to the left
        int left [] = getNSL(a);
        int right [] = getNSE(a);

        int area  = 0; 
        int max_area = 0;

        for(int i = 0; i < a.length; i++)
        {
            area = a[i] * (right[a.length-1 - i] - left[i] -1);
            max_area = Math.max(area, max_area);
        }

        return max_area;
    }


    public static int[] getNSL(int a[])
    {
        Stack<Pair>  s = new Stack<>();
		//Stack<>
		ArrayList<Integer> list = new ArrayList<Integer>();
		//s.push(-1);
		//Nearest smallest to the left
		for(int i = 0; i < a.length; i++)
		{
			if(s.size() == 0)
			{
				list.add(-1);
			}
			else if(s.size() > 0 && s.peek().value < a[i])
			{
				list.add(s.peek().index);
			}
			else if(s.size() > 0 && s.peek().value >= a[i])
			{
				while(s.size() > 0 && s.peek().value >= a[i])
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
			s.push(new LargetsAreaInHistogram().new Pair(i, a[i]));
			
		}
        
		System.out.println(list);
		//int []left = (int [])list.toArray();
		// ArrayList to Array Conversion 
		int left [] = new int[a.length];
        for (int i =0; i < list.size(); i++) 
            left[i] = list.get(i); 

            return left;

    }

    public static int[] getNSE(int a[])
    {
        Stack<Pair> s = new Stack<Pair>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = a.length-1; i >= 0; i--)
		{
			if(s.size() == 0)
			{
				list.add(a.length);
			}
			else if(s.size() > 0 && s.peek().value < a[i])
			{
				list.add(s.peek().index);
			}
			else if(s.size() > 0 && s.peek().value >= a[i])
			{
				while(s.size() > 0 && s.peek().value >= a[i])
				{
					s.pop();
				}
				if(s.size() == 0)
				{
					list.add(a.length);
				}
				else
				{
					list.add(s.peek().index);
				}
			}
			//System.out.println(s.peek().value);
			s.push(new LargetsAreaInHistogram().new Pair(i, a[i]));
			
		}
        
		System.out.println(list);
		int right [] = new int[a.length];
		
		for(int i = 0; i < list.size(); i++)
			right[i] = list.get(i);

        return right;
    }

    public static void main(String[] args) {
        int a [] = {6, 2, 5, 4, 5, 1, 6};
		System.out.println("Maximum Area of the Histogram = "+ new LargetsAreaInHistogram().getMAH(a));

    }
}
