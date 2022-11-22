package dynamicProgramming.miscellaneous;

/**
 * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 *
 * References:
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * https://en.wikipedia.org/wiki/Edit_distance
 */
public class EditDistanceMS {
	
	public int dynamiceEditDistance(char [] str1, char [] str2)
	{
		int t[][] = new int[str1.length+1][str2.length+2];
		
		for(int i = 0; i < t[0].length; i++)
		{
			t[0][i] = i;
		}
		
		for(int i =0 ; i<t.length;i++)
		{
			t[i][0] = i;
		}
		
		for(int i = 1; i<=str1.length;i++)
		{
			for(int j =1; j<=str2.length; j++)
			{
				if(str1[i-1] == str2[j-1]) 
				{
					t[i][j] = t[i-1][j-1];
				}
				else
				{
					int l = Math.min(t[i-1][j],t[i][j-1]);
					t[i][j] = 1+Math.min(l, t[i-1][j-1]);
				}
			}
		}
		
		
		return t[str1.length][str2.length];
	}
	
	public static void main(String []args)
	{
		String str1 = "azced";
		String str2 = "abcdef";
		
		EditDistanceMS edit = new EditDistanceMS();
		
		int result  =  edit.dynamiceEditDistance(str1.toCharArray(), str2.toCharArray());
		
		System.out.println("Answer =  "+ result);
	}

}
