package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DfsOfGraph{
    
    int v;
    LinkedList<Integer> adj[];

    DfsOfGraph(int k)
    {
        this.v = k;

        adj = new LinkedList[v];
        for(int i = 0; i < v; i++)
        {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int source, int dest)
    {
        adj[source].add(dest);
    }

    //this function to do DFS traversal . It uses DfsUtil

    void dfs()
    {
        boolean visited[] = new boolean[v];
        //call the recursive helper function to print DFS traversal
        //starting from all the vertices one by one

        for(int i = 0; i < v ; i++)
        {
            if(visited[i] == false)
            {
                System.out.println("i: " + i);
                System.out.println("Before");
                dfsUtil(i,visited);
                System.out.println("After");
            }
        }

    }

    void dfsUtil(int v, boolean visited[])
    {
        visited[v] = true;
        
        System.out.println(v +"---- ");

        //recur for the all the adjacent vertices to this vertex
        Iterator<Integer> i = adj[v].listIterator();

        while(i.hasNext())
        {
            int edge = i.next();
            //System.out.println("edge = "+edge);
            if(!visited[edge])
            {
                dfsUtil(edge, visited);
            }
        }
    }
    public static void main(String []args)
    {
        DfsOfGraph g = new DfsOfGraph(4);
        g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal"); 
  
        g.dfs(); 
    } 

}
