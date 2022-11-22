package dynamicProgramming.miscellaneous;

public class MinCostPathToReachDestination {

	public static int minCostDynamicProgramming(int cost[][],int m,int n)
	{
		int temp[][] = new int[m+1][n+1];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			//System.out.println(cost[0][i]);
			temp[0][i]=sum+cost[0][i];
			sum=temp[0][i];
		}
		
		sum=0;
		for(int i=0;i<m;i++)
		{
			temp[i][0]=sum+cost[i][0];
			sum=temp[i][0];
			
		}
		
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				//temp[i][j]=cost[i][j]+Math.min(temp[i-1][j],temp[i][j-1]);
				temp[i][j] = cost[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
			}
		}
		
		return temp[m][n];
	}
	
	private static int  min(int a,int b, int c)
	{
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
	
	public static int minCostRec(int cost[][], int m, int n)
	{
        return minCostRec(cost, m, n, 0 , 0);
    }
    
    public static int minCostRec(int cost[][], int m, int n, int x, int y)
    {
        if(x > m || y > n){
            return Integer.MAX_VALUE;
        }
        if(x == m && y == n){
            return cost[m][n];
        }
        
        int t1 = minCostRec(cost, m , n, x+1, y);
        int t2 = minCostRec(cost, m , n, x+1, y+1);
        int t3 = minCostRec(cost, m , n, x, y+1);
        
        return cost[x][y] + min(t1,t2,t3);
    }
    
	public static void main(String[] args) 
	{
		
		//int cost[][]= {{1,2,3},{4,8,2},{1,5,3},{6,2,9}};
		int cost[][]={ {-2, -3,   3},  
                {-5, -10,  1},  
                {10,  30, -5}  
              };
		int result=minCostDynamicProgramming(cost,3,30);
		//int result1 = minCostRec(cost, 3, 3);
		System.out.println("Minimum cost to reach destination is "+result);
	}

}
