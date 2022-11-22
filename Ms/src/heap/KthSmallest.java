package heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

	public static int kthsmallest(int a[], int k)
	{
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		/*PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() 
		{
		    @Override
		    public int compare(Integer a, Integer b) 
		    {
		        return b - a; 
		    }
		}); */
		
		for(int i = 0; i < a.length; i++)
		{
			maxHeap.add(a[i]);
			if(maxHeap.size() > k)
			{
				maxHeap.poll();
			}
			
		}
		
		return maxHeap.peek();
	}
	
	public static void main(String []args)
	{
		int arr [] = {2,12,4,6,8,23};
		int k=3;
		System.out.println("Kth Smallest Element = "+ kthsmallest(arr, k));
	}
}
