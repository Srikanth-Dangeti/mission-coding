package Arrays;

public class LeaderElements {
	
	
	public static void printLeaders(int a[])
	{
		if(a==null||a.length==0)
		{
			return;
		}
		int currentleader=a[a.length-1];
		System.out.println(currentleader);
		for(int i=a.length-2;i>=0;i--)
		{
			if(a[i]>currentleader)
			{
				currentleader=a[i];
				System.out.println(currentleader);
			}
		}
	}
	public static void main(String []args)
	{
		int[] input = { 98, 23, 54, 12, 20, 7, 27 };
		printLeaders(input);
	}

}
