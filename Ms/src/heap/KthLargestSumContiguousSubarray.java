package heap;

import java.util.PriorityQueue;

public class KthLargestSumContiguousSubarray {

	public static int kthLargestSum(int a[], int n, int k)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		int sum [] = new int[n+1];
		
		sum[0] = 0;
		sum[1] = a[0];
		
		for(int i =2; i <=n; i++)
			sum[i] = sum[i-1]+a[i-1];
		
		for(int i =1; i<=n; i++)
		{
			for(int j = i; j<=n; j++)
			{
				int x = sum[j] - sum[i-1];
				
				minHeap.add(x);
				if(minHeap.size()>k) 
				{
					minHeap.poll();
				}
				
				//System.out.println(minHeap);
				
				
			}
		}
		
		return minHeap.poll();
		
	}
	
	public static void main(String[] args) 
	{
		
		int a[] = new int[]{ 10, -10, 20, -40 };
		int n = a.length;
		int k = 6;

		// calls the function to find out the
		// k-th largest sum
		System.out.println(kthLargestSum(a, n, k));
		

	}

}
