package strings;

public class SentencePalindrome {
	
	public static boolean sentencePalindromeornot(String str)
	{
		str=str.toLowerCase();
		int l=0;
		int h=str.length()-1;
		
		while(l<h)
		{
			char lchar=str.charAt(l);
			char hchar=str.charAt(h);
			
			if(!(lchar>='a' && lchar<='z'))
			{
				l++;
			}
			else if(!(hchar>='a' && hchar<='z'))
			{
				h--;
			}
			else if(lchar==hchar)
			{
				l++;
				h--;
			}
			else
				return false;
		}
		
		return true;
	}
	public static void main(String []args)
	{
		String str="too hot to hoot12";
		if(sentencePalindromeornot(str))
			System.out.println("Senetence is palindrome");
		else
			System.out.println("Sentence is not palindrome");
		
	}

}
