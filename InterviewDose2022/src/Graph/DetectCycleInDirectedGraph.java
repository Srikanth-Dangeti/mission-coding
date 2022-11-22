package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleInDirectedGraph{

    int V;
    LinkedList<Integer> adj[];
    
    DetectCycleInDirectedGraph(int k)
    {
        this.V = k;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V; i++)
        {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int dest)
    {
        adj[source].add(dest);
    }

    boolean isCyclic()
    {
        boolean visited [] = new boolean[V];
        boolean rectstack[] = new boolean[V];
        for(int i = 0 ; i < V; i++)
        {
                if(isCyclicUtil(i,visited, rectstack))
                return true;
        }
        return false;
    }

    boolean isCyclicUtil(int i, boolean visited[], boolean recstack[])
    {
        if(recstack[i])
        {
            return true;
        }
        
        if(visited[i])
        {
            return false;
        }

        visited[i] = true;

        recstack[i] = true;

        Iterator<Integer> list = adj[i].listIterator();

        while(list.hasNext())
        {
            int edge = list.next();

            if(isCyclicUtil(edge, visited, recstack))
             return true;
        }
        recstack[i] = false;
        return false;


    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
          
        if(graph.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle"); 
    }
}