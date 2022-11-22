package reucrsion;

public class PermutationWithSpaces {
	
	
	public static void slove(String ip, String op)
	{
		if(ip.length() == 0)
		{
			System.out.println(op);
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		op1.concat(" ");
		op1.concat(ip.charAt(0)+"");
		
		op2.concat(ip.charAt(0)+"");
		//ip.replace(oldChar, newChar)
		slove(ip,op1);
		slove(ip,op2);
		
	}
	
	public static void main(String []args)
	{
		String str= "ABC";
		slove(str," ");
	}

}
