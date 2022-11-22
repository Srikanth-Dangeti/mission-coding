package strings;

import java.util.Arrays;

public class NextPermutation {
	
	public static void swap(int nums[],int a, int b)
	{
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
		
	}
	
	public static void nextPermutation(int [] nums)
	{
		 int n = nums.length;
	        if(n==1)
	            return;
	        
	        int i=1;
	        int lastInc = -1;
	        while(i<n) {    //Find the peak of last ASC order
	            if(nums[i]>nums[i-1])
	                lastInc = i;
	            i+=1;
	        }
	        
	        if(lastInc==-1) {   //Check if array is DSC
	            for(i=0;i<n/2;++i)
	                swap(nums,i,n-i-1);
	            return;
	        }
	        
	        int mn = nums[lastInc];
	        int index = lastInc;
	        int storeindex = lastInc;
			System.out.println("lastInc = "+ lastInc);
	        for(i=lastInc;i<n;++i) {
	            if(nums[i]>nums[lastInc-1] && nums[i]<nums[lastInc]) {
					System.out.println("nums[i] = "+ nums[i] + " > nums[lastinc] = "+ nums[lastInc - 1]+"  ");
					System.out.println("nums[i] = "+ nums[i] + " < nums[lastinc] = "+ nums[lastInc] +" ");
					System.out.println("------------------------------------");
	                index = i;
	            }
	        }
	        //Find element in the range (nums[lastInc-1] to nums[lastInc]) to the right
	        
	        swap(nums,lastInc-1,index);
	        //sort(nums.begin()+lastInc,nums.end());
	        System.out.println(Arrays.toString(nums));
	        System.out.println("StoreIndex = "+storeindex);
		    Arrays.sort(nums, storeindex, n);

	}
	
	public static void main(String []args)
	{
		
		//int nums[] = {2,1,8,7,6,5};
		int nums[] = {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

		System.out.println(Arrays.toString(nums));
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
