package Graph;

public class DfsOfGraphUsingAdjMatrix {

    static int[][] adj;

    static void addEdge(int source, int dest)
    {
        adj[source][dest] = 1;
        adj[dest][source] = 1;
    }

    static void dfs(int start, boolean []visisted)
    {
        System.out.println(start+" ");

        visisted[start] = true;

        for(int i = 0 ;i < adj[start].length; i++)
        {
            if(adj[start][i] == 1 && (!visisted[i]))
            {
                dfs(i,visisted);
            }
        }

    }
    public static void main(String[] args) {
        // number of vertices
        int v = 5;
 
        // number of edges
        int e = 4;
 
        // adjacency matrix
        adj = new int[v][v];
 
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(0, 4);
 
        // Visited vector to so that
        // a vertex is not visited more than once
        // Initializing the vector to false as no
        // vertex is visited at the beginning
        boolean[] visited = new boolean[v];
 
        // Perform DFS
        dfs(0, visited);
    }
    
}
