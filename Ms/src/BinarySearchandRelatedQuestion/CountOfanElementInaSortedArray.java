package BinarySearchandRelatedQuestion;

public class CountOfanElementInaSortedArray {
	
	
	public static void main(String [] args)
	{
		int a [] = {2, 3, 4, 5, 10, 10, 10, 12, 13, 16};
		
		int key = 10;
		
		int first  = FirstAndLastOccurenceOfanElement.firstOccurenceOfEle(a, key);
		
		int last = FirstAndLastOccurenceOfanElement.lastOccurenceOfEle(a, key);
		
		int count = last - first + 1;
		System.out.println("The count of an element"+ key +"in a sorted array = "+count);
	}

}
