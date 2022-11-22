package Graph;

import java.util.LinkedList;

public class GraphRepresetaionUsingList {
	
	static class Graph{
		int v;
		LinkedList <Integer> adjListArray[];
		Graph(int v)
		{
			this.v=v;
			adjListArray = new LinkedList[v];
			for(int i=0;i<v;i++)
			{
				adjListArray[i]=new LinkedList<>();
			}
			
		}
		
	}
	// Adding edge to an undirected Graph
	static void addEdge(Graph graph,int src,int dest)
	{
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}
	//printing the Edges
	static void printEdge(Graph graph)
	{
		for(int i=0;i<graph.v;i++)
		{
			 System.out.println("Adjacency list of vertex "+ i); 
	         System.out.print("head"); 
	         for(Integer k:graph.adjListArray[i])
	         {
	        	 System.out.print(" -> "+k); 
	         }
	         System.out.println();
	         
		}
	}
	public static void main(String []args)
	{
		int V = 5; 
		Graph graph=new Graph(V);
		
		addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
        
        printEdge(graph); 
       
		
		
	}
	
	

}
