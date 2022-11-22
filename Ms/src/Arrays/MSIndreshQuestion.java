package Arrays;

import java.util.Arrays;

public class MSIndreshQuestion 
{
	
	public static void arrangeArray(int a[])
	{
		int start =  0;
		int end  = a.length-1;
		int count = 0;
		while(start<end)
		{
			System.out.println("end = "+end);
			if(a[end] == 0)
			{
				end--;
			}
			else
			{
				swap(start,end,a);
				start++;
				end --;
			}
		}
		
		System.out.println(Arrays.toString(a));
		for(int i = 0; i< a.length;i++)
		{
			if(a[i]!=0)
			{
				swap(count,i,a);
				count++;
			}
		}
		
	}
	
	public static void swap(int i, int j, int a[])
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String []args)
	{
		int a[] = {0, 4, 2, 3, 0, 9, 10, 0, 34, 8, 0, 23, 56, 12};
		arrangeArray(a);
		System.out.println(Arrays.toString(a));
		
	}

}
