package dynamicProgramming.knacpsack01;

public class subSetSum {
    public static boolean printSubSetSum(int[] arr, int n, int sum) {
     boolean S[][] = new boolean[n+1][sum+1];
     for(int i = 0; i < n+1; i++) {
         for(int j = 0; j < sum+1; j++) {
            if(i == 0) {
                S[i][j] = false;
            }
            if( j == 0) {
                S[i][j] = true;
            }
         }
     }
     for(int i = 1; i<n+1; i++){
        for(int j = 1; j< sum+1; j++) {
             if(arr[i-1] <= j) {
              S[i][j] = S[i-1][j-arr[i-1]] || S[i-1][j]; 
             } else {
                S[i][j] = S[i-1][j];
             }
        } 
     }
     return S[n][sum];
    }
    public static void main(String[] args) {
        int arr[]= {1, 2, 3, 8, 9, 10};
        int sum  = 12;
        int n = arr.length;
        System.out.println("is Pair available  " + printSubSetSum(arr, n, sum));
    }

   
}