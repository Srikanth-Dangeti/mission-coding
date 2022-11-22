package DynamicProgramming;
public class TargetSum {
  
  public static int ifTargetSumExists(int[] arr, int sum) {
    if(arr.length == 0) {
      return 0;
    }
    
    int sumOfArrayElement = 0;
    
    for(int i = 0; i < arr.length; i++) {
      sumOfArrayElement = sumOfArrayElement + arr[i];
    }
    
    if(sumOfArrayElement < sum || (sumOfArrayElement + sum) % 2 != 0) {
      return 0;
    }
    
    int sumToCheck = (sumOfArrayElement + sum) / 2;

    return countSubsetsWithSumEqualToGivenSum(arr, sumToCheck);
  }

  private static int countSubsetsWithSumEqualToGivenSum(int[] arr, int sum) {
    if(arr.length == 0 || sum <= 0) {
      return 0;
    }
    
    int n = arr.length;
    
    int[][] count = new int[n+1][sum + 1];
    
    for(int i = 0; i < n+1; i++) {
      count[i][0] = 1;
    }
    
    for(int j = 0; j <= sum; j++) {
      if(arr[0] == j) {
        count[0][j] = 1;
      }
    }
    
    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j <= sum; j++) {
        
        int includingCurrentValue = 0;
        int excludingCurrentValue = 0;
        
        if(arr[i] <= j) {
          includingCurrentValue = count[i - 1][j - arr[i]];
        }
        
        excludingCurrentValue = count[i - 1][j];
        
        count[i][j] = includingCurrentValue + excludingCurrentValue;
      }
    }
    
    return count[n][sum];
  }
  
  public static void main(String[] args) {
    
    int[] arr = {0,0,0,0,0,0,0,0,1};//{1, 2, 1, 3};
    int sum = 1;//3;
    
    System.out.println(TargetSum.ifTargetSumExists(arr, sum));
    
  }

}