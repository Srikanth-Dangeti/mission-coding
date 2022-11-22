package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(R *C).
 * Each element of the matrix can be inserted into the queue only once so the upper bound of iteration is O(R*C),
 * i.e. the number of elements. So time complexity is O(R *C).
 * Space Complexity: O(R*C).
 * To store the elements in a queue O(R*C) space is needed.
 */
public class RottenOranges {
	
	public final static int R = 3;
	public final static int C = 5;
	
	static class Ele{
		int x, y;
		public Ele(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
	}
	
	//Method to check is there any fresh Organges left over in the Matrix
	
	static boolean  checkAll(int a[][])
	{
		for(int i = 0; i< a.length; i++)
		{
			for(int j =0; j < a[0].length; j++)
			{
				if(a[i][j] == 1)
					return true;
			}
		}
			
			return false;
	}
	
	// Method to check whether the cell is delimiter
    // which is (-1, -1)
    static boolean isDelim(Ele temp)
    {
        return (temp.x == -1 && temp.y == -1);
    }
	
	// Method to check whether a cell is valid / invalid
    static boolean isValid(int i, int j)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }
	
	// This Method finds if it is possible to rot all oranges or not.
    // If possible, then it returns minimum time required to rot all,
    // otherwise returns -1
	
	static int rootOranges(int a[][]) 
	{
		
		//Create a Queue of Cell
		Queue<Ele> q = new LinkedList<Ele>();
		Ele temp;
		int ans = 0;
		
		//Store all the organges having rotten Oranges in the first time frame.
		for(int i = 0; i < R; i++)
		{
			for(int j =0 ; j < C; j++)
			{
				if(a[i][j] == 2)
					q.add(new Ele(i,j));
			}
		}
		
		// Separate these rotten oranges from the oranges which will rotten
        // due the oranges in first time frame using delimiter which is (-1, -1)
        q.add(new Ele(-1,-1));
        
        
        
     // Process the grid while there are rotten oranges in the Queue
        
        while(!(q.isEmpty()))
        {
        	// This flag is used to determine whether even a single fresh
            // orange gets rotten due to rotten oranges in the current time
            // frame so we can increase the count of the required time.
        	boolean flag = false;
        	
        	
        	// process all the rotten Oranges in the current time frame
        	
        	
        	while(!isDelim(q.peek()))
        	{
        		temp = q.peek();
        		
        		
        		//Check the right adjacent cell that if can be rotten.
        		if(isValid(temp.x+1, temp.y) && a[temp.x+1][temp.y] == 1)
        		{
        			if(!flag)
        			{
        				//if the first organge to be rotten the please increase the count;
        				ans++;
        				flag = true;
        			}
        			
        			// Make the Orange rotten 
        			a[temp.x+1][temp.y] = 2;
        			
        			//push the adjacent organge to the queue;
        			temp.x++;
        			q.add(new Ele(temp.x,temp.y));
        			
        			temp.x--;
        		}
        		
        		// Check left adjacent cell that if it can be rotten
                if (isValid(temp.x-1, temp.y) && a[temp.x-1][temp.y] == 1)
                 {
                        if (!flag)
                        {
                            ans++;
                            flag = true;
                        }
                        a[temp.x-1][temp.y] = 2;
                        temp.x--;
                        q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
                        temp.x++;
                 }
                
             // Check top adjacent cell that if it can be rotten
                if (isValid(temp.x, temp.y+1) && a[temp.x][temp.y+1] == 1) 
                {
                       if(!flag)
                       {
                           ans++;
                           flag = true;
                       }
                       a[temp.x][temp.y+1] = 2;
                       temp.y++;
                       q.add(new Ele(temp.x,temp.y)); // Push this cell to Queue
                       temp.y--;
                }
                
             // Check bottom adjacent cell if it can be rotten
                if (isValid(temp.x, temp.y-1) && a[temp.x][temp.y-1] == 1) 
                {
                       if (!flag)
                       {
                           ans++;
                           flag = true;
                       }
                       a[temp.x][temp.y-1] = 2;
                       temp.y--;
                       q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
                       temp.y++;
                }
                
                System.out.println(q.peek().x +" -- "+ q.peek().y);
                q.remove();
                 
                
               
        	}
        	
        	System.out.println(q.peek().x+ " <--> "+ q.peek().y); 
        	q.remove();
        	System.out.println(q.isEmpty());
        	//System.out.println(q.peek().x+ " <--> "+ q.peek().y);
        	//System.out.println(q.peek().x+ " <--> "+ q.peek().y); 
        	// If oranges were rotten in current frame than separate the
            // rotten oranges using delimiter for the next frame for processing.
            if (!q.isEmpty()) 
            {
            	System.out.println(q.peek().x+ " <%%> "+ q.peek().y);
                q.add(new Ele(-1,-1));
                System.out.println(q.peek().x+ " <**> "+ q.peek().y);
            }

        }
		
		
     // Return -1 if all arranges could not rot, otherwise ans
        return (checkAll(a))? -1: ans;
	}
	
	public static void main(String []args)
	{
		int a[][] = { 
						{2, 1, 0, 2, 1},
		                {1, 0, 1, 2, 1},
		                {1, 0, 0, 2, 1}
	                };
		
		int ans = rootOranges(a);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
		
		
	}

}
