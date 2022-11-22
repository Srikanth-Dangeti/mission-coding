package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKsortedArray {

	public static void ksort(int a[], int k)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		int j =0;
		for(int i = 0;i < a.length; i++)
		{
			minHeap.add(a[i]);
			if(minHeap.size() > k)
			{
				a[j++] = minHeap.poll();
			}
		}
		System.out.println(minHeap);
		while(minHeap.size() > 0)
		{
			a[j++] = minHeap.poll();
		}
		
		System.out.println(Arrays.toString(a));

    }

	
	public static void main(String []args)
	{
		int k = 3; 
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        ksort(arr, k);
	}
}
