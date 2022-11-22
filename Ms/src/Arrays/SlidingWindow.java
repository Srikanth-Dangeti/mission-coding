package Arrays;
// Java Program to find the maximum for 
// each and every contiguous subarray of size k. 

import java.util.Deque; 
import java.util.LinkedList; 

public class SlidingWindow { 

	// A Dequeue (Double ended queue) based method for printing maximum element of 
	// all subarrays of size k 
	static void printMax(int arr[], int n, int k) 
	{ 
		// Create a Double Ended Queue, Qi that will store indexes of array elements 
		// The queue will store indexes of useful elements in every window and it will 
		// maintain decreasing order of values from front to rear in Qi, i.e., 
		// arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order 
		Deque<Integer> Qi = new LinkedList<Integer>(); 
		int result[] =new int [arr.length -k+1];
		/* Process first k (or first window) elements of array */
		int i; 
		for (i = 0; i < k; ++i) { 
			// For every element, the previous smaller elements are useless so 
			// remove them from Qi 
			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]){ 
                  //System.out.println(Qi);
				Qi.removeLast(); // Remove from rear 
            }

			// Add new element at rear of queue 
			Qi.addLast(i); 
		} 
		
		int j=0;
         //System.out.println("After the Loop " + Qi);
		// Process rest of the elements, i.e., from arr[k] to arr[n-1] 
		for (; i < n; ++i) { 
			// The element at the front of the queue is the largest element of 
			// previous window, so print it 
			result[j++]=arr[Qi.peek()];
			//System.out.println(arr[Qi.peek()] + " "); 

			// Remove the elements which are out of this window 
            //System.out.println("lets Print the Peek "+ Qi.peek());
			while ((!Qi.isEmpty()) && Qi.peek() <= i - k) 
				Qi.removeFirst(); 

			// Remove all elements smaller than the currently 
			// being added element (remove useless elements) 
			while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) 
				Qi.removeLast(); 

			// Add current element at the rear of Qi 
			Qi.addLast(i); 
		} 

		// Print the maximum element of last window 
		System.out.print(arr[Qi.peek()]); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		int arr[] = { 1,3,-1,-3,5,3,6,7 }; 
		int k = 3; 
		printMax(arr, arr.length, k); 
	} 
} 

