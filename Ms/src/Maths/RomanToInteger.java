package Maths;

public class RomanToInteger {

	public int romanToInteger(String s)
	{
		int sum=0;
		char prev='0';
		for(int i=0;i<s.length();i++)
		{
			sum+=getInteger(prev,s.charAt(i));
			prev=s.charAt(i);
		}
		return sum;
	}
	
	public int getInteger(char prev,char ch)
	{
		switch (ch) 
		{
			case 'I':
				return 1;
			
			case 'V':
				if(prev=='I')
					return 3;
				else
				return 5;
			
			case 'X':
				if(prev=='I')
					return 8;
				else
					return 10;
			
			case 'L':
				if(prev=='X')
					return 30;
				else
					return 50;
				
			case 'C':
				if(prev=='X')
					return 80;
				else
					return 100;
				
			case 'D':
				if(prev=='C')
					return 300;
				else
					return 500;
				
			case 'M':
				if(prev=='D')
					return 800;
				else
					return 1000;
			default:
				return 0;
		}
	}
	
	public static void main(String []args)
	{
		RomanToInteger rm=new RomanToInteger();
		//String str="IV";
		String str="MCMXCIV";
		System.out.println("ROMAN TO INTEGER VALUE OF "+str+" ="+rm.romanToInteger(str));
		
		
	}
}
