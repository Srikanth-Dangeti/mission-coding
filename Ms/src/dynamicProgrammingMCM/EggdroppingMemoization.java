package dynamicProgrammingMCM;

import java.util.*;
public class EggdroppingMemoization {
	
	static int t[][] =  new int[1000][1000];
	
	public static int eggdroppingMemoization(int e, int f)
	{
		if(f == 0 || f == 1)
			return f;
		
		if(e == 1)
			return f;
		
		if(t[e][f] != -1)
			return t[e][f];
			
		int min = Integer.MAX_VALUE;
		for(int k = 1; k <= f; k++)
		{
			//int temp = 1+ Math.max(eggdroppingMemoization(e-1, f-1), eggdroppingMemoization(e,f-k));
			int low = 0;
			int high = 0;
			if(t[e-1][f-1] != -1)
			{
			  low = t[e-1][f-1];
			}
			else
			{
				low = eggdroppingMemoization(e-1, f-1);
			}
			if(t[e][f-k] != -1)
			{
				high = t[e][f-1];
			}
			else
			{
				high = eggdroppingMemoization(e, f-k);
			}
			
			int temp = 1 + low + high;
			
			if(temp < min)
			{
				min = temp;
			}
		}

		t[e][f] = min;
		return t[e][f];
	}
	public static void main(String []args)
	{
		int egg = 2;
		int floor = 4;
		
		for(int a [] : t)
		{
			Arrays.fill(a, -1);
		}
		System.out.println("Minimum no of ways in Memoization way = "+eggdroppingMemoization(egg, floor));
	}

}
