package BinarySearchandRelatedQuestion;

public class FindFloorinAnArray {

	public static int  floorSearch(int a[], int key)
	{
		
		if(a == null || a.length ==0)
		{
			return -1;
		}
		
		int start = 0;
		int end = a.length-1;
		int res = 0;
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(key == a[mid])
			{
				return mid;
			}
			else if(key < a[mid])
			{
				end = mid - 1;
			}
			else {
				res = a[mid];
				start = mid + 1;
			}
				
			
			
		}
		
		
		return res;
	}
	public static void main(String []args) {
		int array[] = { 1, 2, 4, 6, 10, 12, 14 }; 
        int num = 7;
        
        int floor = floorSearch(array, num);
        System.out.println("Element " + num + (floor >= 0 ? (" floor of the  " + num + " = "+ floor) : " not found!"));
		
	}
}
