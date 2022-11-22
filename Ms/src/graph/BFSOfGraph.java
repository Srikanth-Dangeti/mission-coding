package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSOfGraph {

	
	int v;
	LinkedList<Integer> adjListArray[];
	BFSOfGraph(int k)
	{
		this.v=k;
		adjListArray=new LinkedList[k];
		for(int i = 0 ; i < v; i++)
		{
			adjListArray[i]=new LinkedList<Integer>();
		}
	}
	
	// Function to add an edge into the graph 
    void addEdge(int v,int w) 
    { 
    	adjListArray[v].add(w); 
    }
    
    void BFS(int s)
    {
    	boolean visited [] = new boolean[v];
    	
    	 // Create a queue for BFS 
    	
    	LinkedList<Integer> Q = new LinkedList<Integer>();
    	
    	visited[s]=true;
    	Q.add(s);
    	
    	while(Q.size() != 0)
    	{
    		 // Dequeue a vertex from queue and print it 
    		s=Q.poll();
    		System.out.print(s +" ");
    		
    		// Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
    		
    		Iterator<Integer> i=adjListArray[s].listIterator();
    		
    		while(i.hasNext())
    		{
    			int n=i.next();
    			
    			if(!visited[n])
    			{
    				visited[n]=true;
    				Q.add(n);
    			}
    		}
    		
    	}
    }
    
 // Driver method to 
    public static void main(String args[]) 
    { 
    	BFSOfGraph g = new BFSOfGraph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
    } 
}
