package stackandrelatedquestions;

public class MaxAreaRectangleinbinarymatrix {
	
	
	
	public static void main(String [] args)
	{
		int a[][] = {
				     {0, 1, 1, 0},
				     {1, 1, 1, 1},
				     {1, 1, 1, 1},
				     {1, 1, 0, 0}
					};
		int b[] = new int[a[0].length];
		for(int j = 0; j< a[0].length;j++)
			b[j] = a[0][j];
		
		
		int mx = MaximumAreaHistogram.getMAH(b, new MaximumAreaHistogram());
		System.out.println("mx= "+mx);
		
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 0; j < a[0].length; j++)
			{
				if(a[i][j] == 0)
				{
					b[j] = 0;
				}
				else
				{
					b[j] = b[j] + a[i][j];
				}
			}
			
			mx = Math.max(mx, MaximumAreaHistogram.getMAH(b, new MaximumAreaHistogram()));
		}
		
		
		
		System.out.println("Maximum Area Rectangle in a Binary matrix = "+ mx);
		

		
	}

}
