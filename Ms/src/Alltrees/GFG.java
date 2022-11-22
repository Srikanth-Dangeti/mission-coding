package Alltrees;
// Java Program to implement the
// above approach
import java.io.*;
import java.util.*;
class GFG {

	// Function to obtain the minimum possible
	// sum from the array by K reductions
	public static int minSum(int a[], int n, int k)
	{
		
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		// Insert elements into the MaxHeap
				for (int i = 0; i < n; i++)
					pq.add(a[i]);

		while (k > 0) {
			int temp = (int) Math.ceil((double) pq.poll() / 2);
			pq.add(temp);
			k--;
		}

		int sum = 0;
		while (!pq.isEmpty()) {
			sum = sum + pq.poll();
		}

		return sum;

		// Implements the MaxHeap
		/*PriorityQueue<Integer> maxheap
			= new PriorityQueue<>(Collections.reverseOrder());

		// Insert elements into the MaxHeap
		for (int i = 0; i < n; i++)
			maxheap.add(a[i]);
		System.out.println(maxheap);
		while (maxheap.size() > 0 && k > 0) {

			// Remove the maximum
			int max_ele = maxheap.poll();
			System.out.println("max_ele= "+max_ele);
			// Insert maximum / 2
			int res = max_ele/2;
			System.out.println(res);
			maxheap.add(res);
			k -= 1;
		}

		// Stores the sum of remaining elements

		int sum = 0;
		while (maxheap.size() > 0)
			sum += maxheap.poll();*/

		//return sum;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int n = 2;
		int k = 1;
		int a[] = { 2,3 };
		System.out.println(minSum(a, n, k));
	}
}
