package dynamicProgrammingMCM;

public class EggDroppingRecurse {
	
	public static int eggdropping(int e, int f)
	{
		
		if(f == 0 || f == 1)
			return f;
		if(e == 1)
			return f;
		
		int min = Integer.MAX_VALUE;
		
		for(int k = 1; k <= f; k++)
		{
			int temp = 1+Math.max(eggdropping(e-1, f-1), eggdropping(e, f-k));
			
			if(temp < min)
			{
				min = temp;
			}
		}
		
		return min;
	}
	public static void main(String []args)
	{
		int egg = 2;
		int floor = 4;
		
		System.out.println("Minimum no of attems to check the floor where egg is dropping = "+eggdropping(egg, floor));
		
	}

}
