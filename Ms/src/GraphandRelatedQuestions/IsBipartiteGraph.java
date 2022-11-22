package GraphandRelatedQuestions;

import java.util.*;
public class IsBipartiteGraph {
	
	
	
	public int V;
	ArrayList<ArrayList<Integer>> adj;
	
	public IsBipartiteGraph(int v)
	{
		this.V = v;
		adj = new ArrayList<ArrayList<Integer>>(V);
		
		for(int i = 0; i < V; i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
	

	public void addEdge(int v, int w)
	{
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	boolean isBipartite(int G[][])  
    { 
        int[] color = new int[V]; 
        for (int i = 0; i < V; i++) 
            color[i] = -1; 
  
        for(int i = 0; i < G.length; i++)
        {
        	for(int j = 0; j < G[0].length; j++)
        	{
        		addEdge(i,  j);
        	}
        }
        for(int i=0;i<V;i++) {
    		// Traversing from uncolored vertices
            if(color[i] == -1) {
                if(!bfs(color, i))
                    return false;
            }
        }
        return true;
      
        
    }
	
	public boolean bfs(int color [], int s)
	{
		//boolean visited[] = new boolean[V];
		
		//create a queue for BFS
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		
		color[s] = 0;
		q.add(s);
		
		while(q.size() != 0)
		{
			
			//deque a vertex from the queue and print it.
			
			s = q.poll();
			//Exploring its neighbours
			//Get all the vertices of the dequeued vertex s
			System.out.println(s);
			Iterator<Integer> it = adj.get(s).iterator();
			
			while(it.hasNext())
			{
				System.out.println("testing");
				int n = it.next();
				// If it's neighbour is colored and if it's color is same as popped vertex , it means it is not possible to give different colors to them , hence returning false
				
				if(color[n] != -1 && color[n] ==color[s])
					return false;
				// If it is already colored , then do nothing
				//if(color[n] != -1)
					//continue;
				// If it not colored yet, assign a color which is different from the popped vertex(temp), which is why 1-color[popped_vertex], this ensures that they will have different colors
				
				color[n] = 1-color[s];
				
			    q.add(n);
			}
			
			
			
			
			
		}
		
		return true;
		
	}
	public static void main(String []args)
	{
		int G[][] = { { 0, 1, 0, 1 }, 
                { 1, 0, 1, 0 },  
                { 0, 1, 0, 1 },  
                { 1, 0, 1, 0 } }; 

		IsBipartiteGraph g = new IsBipartiteGraph(4);
		if (g.isBipartite(G)) 
			System.out.print("Yes"); 
		else
			System.out.print("No"); 
	}

}
