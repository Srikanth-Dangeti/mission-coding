package dynamicProgramming.knacpsack01;

public class minSubSetSumDifference {
    public static void subSetSumDiff(int[] arr, int n, int range) {
        boolean S[][] = new boolean[n+1][range+1];
        for(int i =0; i< n+1; i++) {
            for(int j =0; j< range + 1; j++) {
                if(i == 0) {
                    S[i][j] = false;
                }
                if(j == 0) {
                    S[i][j] = true;
                }
            }
        }
        for(int i =1; i< n+1; i++) {
            for(int j =1; j< range +1; j++) {
                if(arr[i-1] <= j) {
                    S[i][j] = S[i-1][j] || S[i-1][j-arr[i-1]];
                } else {
                    S[i][j] = S[i-1][j];
                }
            }
        }
        int min = 9999999;
        for(int j = 0; j <= (range)/2; j++) {
            if(S[n][j] == true) {
                min = Math.min(min, range - 2*j);
            }
        }
        System.out.println("Minimum Difference is " + min);
        return;
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int range = 0;
        int n = arr.length;
        for(int i =0; i<n;i++) {
            range = range + arr[i];
        }
        subSetSumDiff(arr, n, range);
    }
}