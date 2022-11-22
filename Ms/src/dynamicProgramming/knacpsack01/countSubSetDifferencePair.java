package dynamicProgramming.knacpsack01;

public class countSubSetDifferencePair {
    public static int printCountSubSetDiff(int[] arr, int n, int sum, int diff) 
    {
       
        int S[][] = new int[n+1][sum+1];
        for(int i = 0; i<n; i++) 
        {
            for(int j = 0; j<sum; j++) 
            {
                if(i==0) 
                {
                    S[i][j] = 0;
                }
                if(j==0) 
                {
                    S[i][j] = 1;
                }
            }
        }
        
        for(int i = 1; i < n+1; i++) 
        {
            for(int j = 1; j < sum+1; j++)
            {
	             if(arr[i-1] <= j) 
	             {
	                 S[i][j] = S[i-1][j] + S[i-1][j-arr[i-1]];
	             } else 
	             {
	                S[i][j] = S[i-1][j];
	             }
            }
        }
        return S[n][sum];
    }
    
    public static void main(String[] args) 
    {
        int arr[]= {1, 2, 4, 5};
        int n = arr.length;
        int diff = 1;
        int sum = 0;
        for(int i = 0; i<n; i++) {
          sum = sum + arr[i];
        }
        sum = (diff + sum)/2;
        System.out.println("is Equal Subset difference available ?  " + printCountSubSetDiff(arr, n, sum, diff));
    }
}