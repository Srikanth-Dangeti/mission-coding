package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Snippet {
	public static void main(String[] args) throws Exception {
	   // int[] arr = {8, 12, 16, 4, 0, 0, 20, 12};
		int arr[] = {1,1,2,2,3,3};
	    int k = 1;
	    System.out.println(Arrays.toString(arr));
	    System.out.println(countPairs(arr, k));
	}
	
	 public static int countPairs(int[] arr, int k) {
	     int count = 0;
	     List<Integer> list = new ArrayList<>();
	     //create list of unique elements
	     for(int i = 0; i<arr.length; i++) {
	         if(!list.contains(arr[i])) {
	             list.add(arr[i]);
	         }
	     }
	     Collections.sort(list);
	
	     for (int i = 0; i < list.size() -1; i++)
	        for (int j = i + 1; j < list.size(); j++)
	            if ((k >= 0 ? list.get(j) - list.get(i) : list.get(i) - list.get(j)) == k)
	                count++;
	     return count;
	 }
}

