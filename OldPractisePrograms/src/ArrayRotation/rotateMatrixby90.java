package ArrayRotation;

import java.util.Arrays;
import java.util.Scanner;

public class rotateMatrixby90 {
	
	static void rotateMatrix(int N,int mat[][])
	{
		
		for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in 
            // current square
            for (int y = x; y < N-x-1; y++)
            {
                int temp = mat[x][y];
      
                
                mat[x][y] = mat[y][N-1-x];
      
                
                mat[y][N-1-x] = mat[N-1-x][N-1-y];
      
               
                mat[N-1-x][N-1-y] = mat[N-1-y][x];
      
               
                mat[N-1-y][x] = temp;
            }
        }
		
	}
	
	static void displayMatrix(int n,int a[][])
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				 System.out.print(" " + a[i][j]);
				 System.out.print("\n");
			}
			 //System.out.print("\n");
		}
	}
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int a[][]= {
				{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {4,5,7}
		};
		System.out.println("Testing");
		System.out.println((int)(a[1][1]-'1'));
		rotateMatrix(n,a);
		displayMatrix(n,a);
		
	}

}
