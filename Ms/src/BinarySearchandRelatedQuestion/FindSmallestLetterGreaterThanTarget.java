package BinarySearchandRelatedQuestion;

public class FindSmallestLetterGreaterThanTarget {
	
	
	public static int  findsmallestlettergreatestthantarget(char a[], char key)
	{
		
		if(a == null || a.length ==0)
		{
			return -1;
		}
		
		int start = 0;
		int end = a.length-1;
		char res = '0';
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			
			if(key == a[mid])
			{
				return mid;
			}
			else if(key < a[mid])
			{
				res = a[mid];
				end = mid - 1;
			}
			else 
			{
				
				start = mid + 1;
			}
				
		}
		if(res==' ' && a.length!=0) return a[0];
		
		return res;
	}
	
	public static void main(String []args) {
		char array[] = {'c', 'f', 'j'};
        char ch = 'a';
        
        char rs = (char) findsmallestlettergreatestthantarget(array, ch);
        System.out.println(rs);
        //char res = (char) (floor -'0');
        System.out.println("Element " + ch + " Smallest letter greater than targe  = "+ rs+ " found");
		
	}

}
