package dynamicProgramming.miscellaneous;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInUndirectedGraph {

	int v;
	LinkedList<Integer> adj[];
	CycleInUndirectedGraph(int k)
	{
		this.v=k;
		adj = new LinkedList[k];
		
		for(int i = 0; i < v; i++)
			adj[i] =  new LinkedList();
	}
	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	
	boolean isCyclicUtil(int v, boolean visited[], int parent) 
	{
		// Mark the current node as visited 
        visited[v] = true; 
        Integer i; 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
  
            // If an adjacent is not visited, then recur for that 
            // adjacent 
            if (!visited[i]) 
            { 
                if (isCyclicUtil(i, visited, v)) 
                    return true; 
            } 
  
            // If an adjacent is visited and not parent of current 
            // vertex, then there is a cycle. 
            else if (i != parent) 
                return true; 
        }
		return false;
	}
	
	boolean isCyclic()
	{
		boolean visited [] = new boolean[v];
		for(int i = 0 ; i < v; i++)
			visited[i]=false;
		// Call the recursive helper function to detect cycle in 
        // different DFS trees 
		
		for(int i = 0 ; i  < v; i++)
		{
			if(!visited[i])
				if (isCyclicUtil(i, visited, -1)) 
                    return true; 
		}
		
		return false;
		
	}
	
	
	// Driver method to test above methods 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
    	CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        if (g1.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
  
        CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(3); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        if (g2.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
    } 
}
