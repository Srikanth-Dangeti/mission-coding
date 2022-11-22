package GraphandRelatedQuestions;

import java.util.*;

import graph.BFSOfGraph;

public class BfsOfGraphAjdList {
	
	int V;
	ArrayList<ArrayList<Integer>> adj;
	
	//constructor
	
	public BfsOfGraphAjdList(int v)
	{
		this.V = v;
		adj = new ArrayList<ArrayList<Integer>>(V);
		
		for(int i = 0; i < V; i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
	
	void addEdge(int v, int w)
	{
		adj.get(v).add(w);
	}
	//print the bfs traversal from a given source
	public void bfs(int s)
	{
		boolean visited[] = new boolean[V];
		
		//create a queue for BFS
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		
		visited[s] = true;
		q.add(s);
		
		while(q.size() != 0)
		{
			
			//deque a vertex from the queue and print it.
			
			s = q.poll();
			System.out.print(s + " ");
			
			
			//Get all the vertices of the dequeued vertex s
			
			Iterator<Integer> it = adj.get(s).iterator();
			
			while(it.hasNext())
			{
				int n = it.next();
				if(!visited[n])
				{
					visited[n] = true;
					q.add(n);
				}
			}
			
			
			
			
			
		}
		
	}
	
	// Driver method to 
    public static void main(String args[]) 
    { 
    	BfsOfGraphAjdList g = new BfsOfGraphAjdList(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.bfs(2); 
    }
	

}
