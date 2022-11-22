package Arrays;

public class SumofArray {

	public static int sum(int[] a, int index)
	{
		if(a.length<=index)
		{
			return 0;
		}
		
		return a[index]+sum(a,index+1);
		
	}
	public static void main(String []args)
	{
		int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(sum(array, 0));
	}
}
