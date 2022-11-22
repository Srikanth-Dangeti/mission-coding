package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class CountingFrequncy {
	
	
	public  static void countFreq(int a[])
	{
		HashMap<Integer,Integer>h=new HashMap<Integer,Integer>();
		
		Arrays.sort(a);
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		for(int i:a)
		{
			if(h.containsKey(i))
			{
				h.put(i, h.get(i)+1);
			}
			else
				h.put(i,1);
		}
		System.out.println(h);
		
	}
	public static void main(String []args)
	{
		int array[]= {1,2,3,4,5,5,5,1,3,4,2};
		countFreq(array);
		
		
		
	}

}
