package slidingWindowProblems;

public class MaximumSumSubarrayofsizeK {
	
	public static int getMaxSum(int a[], int size, int k)
	{
		
		int i = 0 , j = 0;
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while(j < size)
		{
			sum = sum + a[j];
			
			if(j - i + 1 < k)
			{
				j++;
			}
			else if(j - i + 1 == k)
			{
				max = Math.max(max, sum);
				sum = sum - a[j];
				i++;
				j++;
			}
			
		}
		
		return max;
		
		
	}
	
	/* Driver program to test above function */
    public static void main(String[] args)  
    { 
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20}; 
        int k = 4; 
        int n = arr.length; 
        System.out.println(getMaxSum(arr, n, k)); 
    } 

}
