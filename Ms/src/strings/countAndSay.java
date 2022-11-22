package strings;

public class countAndSay {
	
	public static String countAndSay(int n)
	{
		if(n==1){
            return "1";
        }
        StringBuilder sb=new StringBuilder();
        
        String s=countAndSay(n-1);

        char c=s.charAt(0);
        
        int count=1;
        
        for(int i=1;i<s.length();i++){
        	
            if(s.charAt(i)==c){
                count++;
            }else{
            	
                sb.append(count).append(c);
                c=s.charAt(i);
                count=1;
            }
        }
        
        if(count>0){
            sb.append(count).append(c);
        }
        
        System.out.println("Printing sb= "+sb);
        return sb.toString();
        
	}
	public static void main(String []args)
	{
		int n=5;
		System.out.println(countAndSay(n));
		
		
		
	}

}
