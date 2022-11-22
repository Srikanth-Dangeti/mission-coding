package graph.TopologicalSort;

import java.util.*;

public class TopologicalSort {
	
private int V;
	
	private ArrayList<ArrayList<Integer>> adj;
	
	public TopologicalSort(int v) {
		
		this.V = v;
		adj = new ArrayList<ArrayList<Integer>>(v);
		for(int  i = 0; i < V; i++)
		{
			adj.add(new ArrayList<Integer>());
			//System.out.println(adj);
		}
		
	}
	
	void addEdge(int v, int w)
	{
		//System.out.println("Value of = "+adj.get(v));
		adj.get(v).add(w);
		System.out.println(adj.toString());
	}
	
	public void topologicalSortUtil(int k, boolean visited[], Stack<Integer> stack)
	{
		//mark the current node as visited.
		visited[k] = true;
		
		int i;
		
		// Recur for all the vertices adjacent  
        // to thisvertex 
		
		System.out.println("Value of K before While loop = "+ k);
		Iterator<Integer> it = adj.get(k).iterator();
		
		while(it.hasNext())
		{
			i = it.next();
			
			System.out.println("value of i = "+ i);
			
			if (!visited[i])  
                topologicalSortUtil(i, visited, stack);  
			
		}
		
		// Push current vertex to stack  
		// which stores result 
		        stack.push(new Integer(k));  
		
	}
	
	public void topologicaSort()
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		//Mark all the vertieces as  not visited 
		boolean visited[] = new boolean[V];
		
		// Topological Sort starting from all vertices one by one  
		 for(int i = 0; i < V; i++)
		 {
			 if(visited[i] == false)
			 {
				 System.out.println("value of i in topologicalsort method = "+i);
				 topologicalSortUtil(i, visited, stack);
				 System.out.println("Came back to the calling location");
			 }
		 }
		 
		 while(stack.isEmpty() ==false)
		 {
			 System.out.print(stack.pop() + " ");  
		 }
		
		
	}
	
	public static void main(String []args)
	{
		TopologicalSort g = new TopologicalSort(2);
		//GraphTopological g = new GraphTopological(6);
		g.addEdge(1, 0);
		/*g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1);  */
        
        System.out.println( 
        		"Following is a Topological " +  
        		                           "sort of the given graph"); 
        
        g.topologicaSort();
  
		 
	}

}
