package graph;

import java.util.LinkedList;

public class GraphRepresentationInAjdList {

	public static class Graph{
		
		int v;
		LinkedList<Integer> adjListArray[];
		Graph(int k)
		{
			this.v=k;
			adjListArray=new LinkedList[k];
			for(int i = 0 ; i < v; i++)
			{
				adjListArray[i]=new LinkedList<Integer>();
			}
		}
		
	}
	
	static void  addEdge(Graph graph, int src, int dest) {
		
		// Add an edge from src to dest. 
		graph.adjListArray[src].add(dest);
		
		// Since graph is undirected, add an edge from dest 
        // to src also 
		
		graph.adjListArray[dest].add(src);
		
	}
	
	// A utility function to print the adjacency list  
    // representation of graph 
	
	static void printGraph(Graph graph)
	{
		for(int i = 0 ; i < graph.v; i++)
		{
			System.out.println("Adjancey List of Vertex v = "+ i);
			System.out.println("head");
			
			for(Integer pc : graph.adjListArray[i])
			{
				System.out.println(" --> "+pc);
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String []args)
	{
		  // create the graph given in above figure 
        int V = 5; 
        Graph graph = new Graph(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        printGraph(graph); 
	}
}
