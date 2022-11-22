package heap;

public class SumofElements {

	//P. Sum of Elements between k1 smallest and k2 smallest numbers
	public static void main(String []args)
	{
		int a[] = {1, 3, 12, 5, 15, 11};
		int k1 = 3;
		int k2 = 6;
		
		int first = KthSmallest.kthsmallest(a, k1);
		
		int second = KthSmallest.kthsmallest(a, k2);
		int sum = 0;
		for(int i = 0; i < a.length; i++)
		{
			if(first < a[i] && a[i] < second)
			{
				sum = sum+a[i];
			}
		}
		
		System.out.println("Sum of Elements between k1 smallest and k2 smallest numbers = "+ sum);
	}
}
