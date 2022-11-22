package dynamicProgramming.knacpsack01;

public class equalSumPartition {
    public static boolean printEqualSubSetSum(int[] arr, int n) {
          int sum = 0;
          for(int i = 0; i<n; i++) {
              sum = sum + arr[i];
          }
          int checkSum = 0;
          checkSum = checkSum +  sum/2;
          boolean S[][] = new boolean[n+1][checkSum+1];

        if( sum%2 != 0){
                return false;
        } else{
              for(int i = 0; i<n+1; i++) {
                   for(int j =0; j<checkSum+1; j++) {
                       if(i==0) {
                         S[i][j] = false;
                       }
                       if(j==0) {
                           S[i][j] = true;
                       }
                   }
              }
             for(int i = 1; i < n+1; i++){
                 for(int j = 1; j < checkSum+1; j++) {
                   if(arr[i-1] <= j){
                     S[i][j] = S[i-1][j] || S[i-1][j-arr[i-1]];
                   }else {
                    S[i][j] = S[i-1][j];
                   }
                 }
             }
        }
        return S[n][checkSum];
    }
    public static void main(String[] args) {
        int arr[]= {1, 5, 11, 5};
        int n = arr.length;
        System.out.println("is Equal Subset Sum available ?  " + printEqualSubSetSum(arr, n));

    }
}