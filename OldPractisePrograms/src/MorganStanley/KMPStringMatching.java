package MorganStanley;

public class KMPStringMatching {
	
	public static void KMPSearch(String pat,String txt)
	{
		int lps[]=new int[pat.length()];
		computeLPSArray(pat,lps);
		int i=0,j=0;
		while(i<txt.length())
		{
			if(pat.charAt(j)==txt.charAt(i))
			{
				i++;
				j++;
			}
			if(j==pat.length())
			{
				System.out.println("Found pattern "+ "at index " + (i - j)); 
				j=lps[j-1];		
			}
			else if(i<txt.length()&&pat.charAt(j)!=txt.charAt(i))
			{
				if(j!=0)
				{
					j=lps[j-1];
				}
				else
					i=i+1;
				
			}
		}
		
	}
	public static void computeLPSArray(String pat,int lps[])
	{
		int len=0;
		int i=1;
		lps[0]=0;
		while(i<pat.length())
		{
			if(pat.charAt(i)==pat.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else
			{
				if(len!=0)
				{
					len=lps[len-1];
					
				}
				else
				{
					lps[i]=len;
					i++;
				}
			}
		}
		
	}
	public static void main(String []args)
	{
		String txt = "ababcabdabababd"; 
		String pat = "ababd"; 
		KMPSearch(pat, txt); 
	}

}
