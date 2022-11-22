package heap;

import java.util.PriorityQueue;


public class ConnectRopesToMinisetheCost {
	
	
	public static int connectropes(int a[])
	{
		int cost =0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i =0 ; i< a.length; i++)
			minHeap.add(a[i]);
		
		System.out.println(minHeap);
		while(minHeap.size() >= 2)
		{
			int first = minHeap.poll();
			System.out.println(first);
			int second = minHeap.poll();
			
			cost  = cost + first + second;
			minHeap.add(first+second);
		}
		
		
		return cost;
	}
	
	public static void main(String []args)
	{
		int a[] = {1,2,3,4,5};
		System.out.println("Minimised Cost to Connet Ropes = "+connectropes(a));
	}
}
