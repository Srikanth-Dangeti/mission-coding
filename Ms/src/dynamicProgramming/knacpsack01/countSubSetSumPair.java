package dynamicProgramming.knacpsack01;

public class countSubSetSumPair {
    public static int printCountSubSetSum(int[] arr, int n, int sum) {
        int count = 0;
        int S[][] = new int[n+1][sum+1];
        for(int i = 0; i<n+1; i++) {
            for(int j =0; j<sum+1; j++) {
                if(j==0) {
                    S[i][j] = 1;
                }
            }
       }
       for(int i = 1; i < n+1; i++){
        for(int j = 1; j < sum+1; j++) {
          if(arr[i-1] <= j){
            S[i][j] = S[i-1][j] + S[i-1][j-arr[i-1]];
          }else {
           S[i][j] = S[i-1][j];
          }
        }
    }
        return  S[n][sum];
    }
    public static void main(String[] args) {
        int arr[]= {2, 3, 5, 6, 8, 10};
        int n = arr.length;
        int sum = 10;
        System.out.println("is Equal Subset Sum available ?  " + printCountSubSetSum(arr, n, sum));
    }
}