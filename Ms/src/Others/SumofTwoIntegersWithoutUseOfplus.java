package Others;

public class SumofTwoIntegersWithoutUseOfplus {

	
	public static int getSum(int a, int b) {
        if(b==0)
            return a;
        else
         return   getSum(a^b,((a&b)<<1));
    }
	public static void main(String []args)
	{
		System.out.println(getSum(2,5));
		
		System.out.println(2 ^ 5);
		
		System.out.println(2&5 << 1);
	}
}
