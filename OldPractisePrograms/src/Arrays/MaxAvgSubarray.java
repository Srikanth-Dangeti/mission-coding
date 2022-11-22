package Arrays;

public class MaxAvgSubarray {
	
	public static int getMaxAvgSubarrayStartIndex(int a[],int k)
	{
		
		if(k>a.length)
		{
			throw new IllegalArgumentException("k should be less than or equal to n");
		}
		
		if(k==0)
		{
			return 0;
		}
		
		int sum=0;
		for(int i=1;i<k;i++)
		{
			sum+=a[i];
		}
		int maxsum=sum;
		int maxsumindex=0;
		
		return 0;
	}
	public static void printMaxAvgSubarray(int[] input, int k) {
        System.out.print("Maximum average subarray of length " + k + " is:  ");
        int index = getMaxAvgSubarrayStartIndex(input, k);
        for(int i =0 ; i < k; i++) {
            System.out.print(input[index++] + " ");
        }
    }
	public static void main(String []args)
	{
		int[] input = {11, -8, 16, -7, 24, -2, 3};
		int k=3;
		printMaxAvgSubarray(input, k);
	}

}
