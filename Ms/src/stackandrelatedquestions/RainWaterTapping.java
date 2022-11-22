package stackandrelatedquestions;

import java.util.Arrays;

public class RainWaterTapping {
	
	public static int getRainWater(int a[])
	{
		int maxl[] = new int[a.length];
		
		int maxr[] =  new int[a.length];
		
		maxl[0] = a[0];
		
		for(int i = 1; i < a.length; i++)
			maxl[i] = Math.max(maxl[i-1], a[i]);
		
		maxr[a.length-1] = a[a.length -1];
		
		System.out.println(Arrays.toString(maxl));
		
		for (int i = a.length - 2; i>=0; i--)
		{
			maxr[i] = Math.max(maxr[i+1], a[i]); 
		}
		
		System.out.println(Arrays.toString(maxr));
		//int water[] = new int [a.length];
		int sum = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			System.out.println("maxl[i], maxr[i] , a[i]= "+ maxl[i] +"  " +maxr[i] +" " +a[i]);
			sum += Math.min(maxl[i],maxr[i]) - a[i];
		}


		return sum;
		
	}
	
	public static void main(String []args)
	{
		int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println("Rain water in the Area of = "+ getRainWater(a));
	}

}
