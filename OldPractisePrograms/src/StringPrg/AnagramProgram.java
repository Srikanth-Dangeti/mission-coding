package StringPrg;

import java.util.Arrays;

public class AnagramProgram {
	
	static void isAnagram(String s1,String s2)
	{
		String str1=s1.replace("\\s", "");
		String str2=s2.replace("\\s", "");
		
		boolean status =true;
		if(str1.length()!=str2.length())
		{
			status=false;
		}
		else
		{
			char []arr1=str1.toCharArray();
			char []arr2=str2.toCharArray();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			status =Arrays.equals(arr1, arr2);
			
		}
		if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
            System.out.println();
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
            System.out.println();
        }
	}
	public static void main(String []args)
	{
		isAnagram("Mother In Law", "Hitler Woman");
		 
        isAnagram("keEp", "peeK");
 
        isAnagram("SiLeNt CAT", "LisTen AcT");
 
        isAnagram("Debit Card", "Bad Credit");
 
        isAnagram("School MASTER", "The ClassROOM");
 
        isAnagram("DORMITORY", "Dirty Room");
 
        isAnagram("ASTRONOMERS", "NO MORE STARS");
 
        isAnagram("Toss", "Shot");
 
        isAnagram("joy", "enjoy");
	}

}
