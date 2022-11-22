package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * Input : arr = [3,3,3,3,5,5,5,2,2,7]
Output : 2
Explanation :
Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Other Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
 * 
 * 
 * 3--> 4
 * 5--> 3
 * 2--> 2
 * 7--> 1
 * 
 */
public class Interview2nd {

	
	public static int minimumSet(int a[])
	{
		
		
		if(a== null || a.length==0)
		{
			return 0;
		}
		int size = a.length;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < a.length; i++)
		{
			if(map.containsKey(a[i]))
			{
				map.put(a[i],map.get(a[i])+1);
			}
			else
			{
				map.put(a[i],1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(map.values());
		Collections.sort(list);// nlogn
		
		
		int minsize = 0;
		int sum = 0;
		for(int i =list.size()-1; i>=0; i--)
		{
			sum = sum+list.get(i);
			minsize++;
			if(sum >= size/2)
			{
				break;
			}
		}	
		
		//n/2 
		
		// Time complexity -- > n+nlogn+n -- > nlogn
		//space also --- > o(n)
		
		
		return minsize;
	}
	
	public static void main(String args[])
	{
		
		//int a[] = {3,3,3,3,5,5,5,2,2,7};
		//int a[] = {1,9};
		
		//int a[] = {1,2,3,4,5,6};
		int a[] = {5,5,5,5};
		System.out.println("Minimum size of the set is = "+ minimumSet(a));
		
	}
	
	
}
