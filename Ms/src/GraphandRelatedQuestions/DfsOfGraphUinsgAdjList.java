package GraphandRelatedQuestions;

import java.util.*;
public class DfsOfGraphUinsgAdjList {
	
	int V;
	ArrayList<ArrayList<Integer>> adj;
	public DfsOfGraphUinsgAdjList(int v)
	{
		this.V = v;
		adj = new ArrayList<ArrayList<Integer>>(v);
		
		for(int i = 0; i < V; i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
	
	void addEdge(int v, int w)
	{
		adj.get(v).add(w);
	}
	// The function to do dfs traversal . it uses recursive DFSUtil()
	public void dfs()
	{
		boolean visited [] = new boolean[V];
		
		//call the recursive helper function to print DFS traversal
		// Starting from all vertices one by one.
		
		for(int i = 0; i < V; i++)
		{
			if(visited[i] == false)
			{
				dfsUtil(i, visited);
			}
		}
	}
	
	public void dfsUtil(int k, boolean visited[])
	{
		visited[k] = true;
		
		System.out.println(k + " ");
		
		//Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj.get(k).iterator();
		while(it.hasNext())
		{
			int i = it.next();
			if(!visited[i])
			{
				dfsUtil(i, visited);
			}
			
		}
		
	}
	public static void main(String[] args)
	{
		DfsOfGraphUinsgAdjList g = new DfsOfGraphUinsgAdjList(4);
		 	g.addEdge(0, 1); 
		 	g.addEdge(0, 2); 
	        g.addEdge(1, 2); 
	        g.addEdge(2, 0); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 3); 
	        
	        g.dfs();
       
		
	}

}
