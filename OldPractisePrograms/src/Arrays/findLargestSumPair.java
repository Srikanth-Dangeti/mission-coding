package Arrays;

public class findLargestSumPair {
	
	static int findLargestSumPai1r(int a[])
	{
		
		int first;
		int second;
		if(a[0]>a[1])
		{
			first=a[0];
			second=a[1];
			
		}
		else
		{
			first=a[1];
			second=a[0];
		}
		for(int i=2;i<a.length;i++)
		{
			if(a[i]>first)
			{
				second=first;
				first=a[i];
			}
			else if(a[i]>second&&a[i]!=first)
			{
				second = a[i];
			}
		}
		
		return(first+second); 
	}
	
	public static void main(String []args)
	{
		int a[]= {12, 34, 10, 6, 40};
		System.out.println(findLargestSumPai1r(a));
	}

}
