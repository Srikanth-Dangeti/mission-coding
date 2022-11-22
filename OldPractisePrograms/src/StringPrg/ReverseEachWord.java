package StringPrg;

public class ReverseEachWord {
	
	static void reverseEachWordOfString(String str)
	{
		String words[]=str.split(" ");
		String revstring="";
		for(int i=0;i<words.length;i++)
		{
			String Eachword=words[i];
			String RevEachword="";
			StringBuffer sb=new StringBuffer(Eachword);
			sb.reverse();
			RevEachword=sb.toString();
			
			revstring=revstring+RevEachword+" ";
		}
		System.out.println(str);
        
		System.out.println();
        System.out.println(revstring);
         
        System.out.println("-------------------------");
	}
	public static void main(String[] args) 
    {
        reverseEachWordOfString("Java Concept Of The Day");
         
        reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts");
         
        reverseEachWordOfString("I am string not reversed");
         
        reverseEachWordOfString("Reverse Me");
    }

}
