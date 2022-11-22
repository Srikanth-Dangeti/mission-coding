package GraphandRelatedQuestions;

import java.util.*;

public class DetectCycleInaDirectedGraph {
	
	
	int V;
	
	ArrayList<ArrayList<Integer>> adj;
	
	public DetectCycleInaDirectedGraph(int v)
	{
		this.V = v;
		
		adj =  new ArrayList<ArrayList<Integer>>(V);
		
		for(int i = 0; i < V; i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int v, int w)
	{
		adj.get(v).add(w);
	}
	
	public boolean isCyclic()
	{
		int [] visited =  new int[V];
		
		for(int i = 0; i < V; i++)
		{
			visited[i] = 1;
			
		}
		
		return false;
	}
	
	public static void main(String []args)
	{
		DetectCycleInaDirectedGraph graph = new DetectCycleInaDirectedGraph(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
	}

}
