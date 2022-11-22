package Graph;

import java.util.Iterator;
import java.util.LinkedList;
/*Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
Auxiliary Space: O(V)*/
public class BfsOfGraph {
    
    int v;
    LinkedList<Integer> adj[];
    BfsOfGraph(int k)
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

   void bfs(int startingVertext)
    {
        boolean visited [] = new boolean[v];
        
        LinkedList<Integer> queue = new LinkedList<>();

        // mark the current node as visited and enqueue it.
        visited[startingVertext] = true;
        queue.add(startingVertext);
        
        while(!queue.isEmpty())
        {
            //dequeue the vertex from the queue and print it.
            startingVertext = queue.poll();
            System.out.print(startingVertext+ "-->");

            Iterator<Integer> i = adj[startingVertext].listIterator();

            while(i.hasNext())
            {
                int edge = i.next();
                if(!visited[edge])
                {
                    visited[edge] = true;
                    queue.add(edge);
                }
            }

        }

    }
    public static void main(String[] args) 
    {
        BfsOfGraph g = new BfsOfGraph(4);
 
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
