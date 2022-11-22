package Oracle;

import java.util.Scanner;

public class Patternmatching {
	public static void patternmatch(String txt,String pat)
    {
		
		//boolean flag=txt.contains(pat);
        for(int i=0;i<txt.length()-pat.length();i++)
        {
            int j;
            for( j=0;j<pat.length();j++)
            {
                if(txt.charAt(i+j)!=pat.charAt(j))
                   break;
                   
            }
            if (j == pat.length()) 
            {
                System.out.println("found");
                break;
            }
                else
                System.out.println("not found");
        }
        
    }
	public static void main (String[] args) {
	    
	    Scanner sc=new Scanner(System.in);
	    
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        String txt=sc.next();
	        String pat=sc.next();
	        patternmatch(txt,pat);
	    }
	    
	    
	}

}
