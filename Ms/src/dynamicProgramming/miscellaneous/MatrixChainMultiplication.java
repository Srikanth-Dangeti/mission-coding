package dynamicProgramming.miscellaneous;

import java.util.HashMap;

public class MatrixChainMultiplication {

	public static int MatrixChainMultiplicationInRecursion(int a[],int i,int j)
	{
		if(i==j)
			return 0;
		int min=Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++)
		{
			int count=MatrixChainMultiplicationInRecursion(a,i,k)+MatrixChainMultiplicationInRecursion(a,k+1,j)+a[i-1]*a[k]*a[j];
			if (count < min) 
                min = count; 
		}
		return min;
	}
	
	public static void main(String[] args) {
		int a[]= {1,2,3,4};
		int size=a.length;
		System.out.println("Minimum no of mulitiplications is"+MatrixChainMultiplicationInRecursion(a,1,size-1));
		
	}

}
