package Arrays;

public class pivotElement {

	public static int findPivotBinarySearchTest(int a[])
	{
		if(a==null||a.length==0)
		{
			return -1;
		}
		if(a.length==1||a[0]<a[a.length-1])
		{
			return 0;
		}
		int start=0,end=a.length-1;
		while(start<end)
		{
			int mid=(start+end)/2;
			if(mid<a.length-1&&a[mid]>a[mid+1])
			{
				return (mid+1);
			}
			else if(a[start]<=a[mid])
			{
				start=mid+1;
				
			}
			else
			{
				end=mid-1;
			}
			
		}
		return 0;
		
	}
	public static void main(String[]args)
	{
		int arrays[]= {12,4,3,6,5,1};
		System.out.println(findPivotBinarySearchTest(arrays));
	}
}
