package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSOfGraph {

	int v;
	LinkedList<Integer> adj[];
	
	DFSOfGraph(int k)
	{
		this.v=k;
		adj =new LinkedList[v];
		
		for(int i = 0; i < v; i++)
		{
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	// The function to do DFS traversal. It uses recursive DFSUtil() 
	void dfs()
	{
		boolean visited [] = new boolean[v];
		
		// Call the recursive helper function to print DFS traversal 
        // starting from all vertices one by one 
		for(int i = 0; i < v ; i++)
		{
			if(visited[i]== false)
				dfsUtil(i, visited);
		}
	}
	
	void dfsUtil(int v, boolean visited[])
	{
		visited[v]=true;
		System.out.print(v +" ");
		
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator();
		
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				dfsUtil(n,visited);
			}
		}
	}
	
	public static void main(String args[]) 
    { 
        DFSOfGraph g = new DFSOfGraph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal"); 
  
        g.dfs(); 
    } 
}
