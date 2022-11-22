package Oracle;

public class MinimumSwapsforBracketBalancing {
	
    public static int swapCount(String s)
    {
    	int swap=0;
    	char []ch=s.toCharArray();
    	int countleft=0,countright=0;
    	int imbalance=0;
    	for(int i=0;i<ch.length;i++)
    	{
    		if(ch[i]=='[')
    		{
    			countleft++;
    			if(imbalance>0)
    			{
    				swap=swap+imbalance;
    				
    				imbalance--;
    			}
    		}
    		else if(ch[i]==']')
    		{
    			countright++;
    			
    			imbalance=(countright-countleft);
    		}
    			
    	}
    	
    	return swap;
    }
    public static void main(String []args)
	{
		String s = "[]][]["; 
		System.err.println(swapCount(s));
	}

}
