package heap;

import java.util.PriorityQueue;

public class klargest {

	public static void findKLargest(int a[], int k)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i = 0; i < a.length; i++)
		{
			minHeap.add(a[i]);
			System.out.println(minHeap);
			if(minHeap.size() > k)
			{
				minHeap.poll();
			}
		}
		
		while(minHeap.size() > 0)
		{
			System.out.println(minHeap.peek());
			minHeap.poll();
		}
	}
	
	public static void main(String []args)
	{
		int arr [] = {7, 10, 4, 3, 20, 15};
		int k =3;
		
		System.out.println("k largest elements are = ");
		findKLargest(arr,k);
	}
}
