package Sorting;

public class Test {
	public static void main(String[] args) throws ArithmeticException
	{
		int n = 2;
		/*int [] arr = new int[n];
		for(int i = 1; i <=n; i++)
		{
			arr[i] = i;
		}*/
		int count = 0;
		int lcm;
		for(int i = 1; i <= n; i++)
		{
			lcm = i*n/gcd(i,n);
	        if(lcm <= n)
	        {
	        	count= count+ i;
	        }
		}
		System.out.println(count);
	}
	static int gcd(int a, int b)
	{
		int gcd = 0;;
		for(int i = 1; i <= a && i <= b; ++i)
        {
            // Checks if i is factor of both integers
            if(a % i == 0 && b % i == 0)
                gcd = i;
        }
		return gcd;
	}
}
