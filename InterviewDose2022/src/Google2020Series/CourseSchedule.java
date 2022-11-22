package Google2020Series;

/**
 * https://leetcode.com/problems/course-schedule/
 * Time Complexity:
 * O(∣E∣+∣V∣) where
 * ∣V∣ is the number of courses, and
 * ∣E∣ is the number of dependencies.
 *
 * As in the previous algorithm, it would take us
 * ∣E∣ time complexity to build a graph in the first step.
 * Since we perform a postorder DFS traversal in the graph, we visit each vertex and each edge once and only once in the worst case, i.e.
 *
 * ∣E∣+∣V∣.
 *
 * Space Complexity:
 * O(∣E∣+∣V∣), with the same denotation as in the above time complexity.
 *
 * We built a graph data structure in the algorithm, which would consume
 * ∣E∣+∣V∣ space.
 * In addition, during the backtracking process, we employed two bitmaps (path and visited) to keep track of the visited path and the status of check respectively, which consumes
 * 2⋅∣V∣ space.
 * Finally, since we implement the function in recursion, which would incur additional memory consumption on call stack. In the worst case where all nodes chained up in a line, the recursion would pile up
 *
 * ∣V∣ times.
 * Hence the overall space complexity of the algorithm would be
 *
 * O(∣E∣+4⋅∣V∣)=O(∣E∣+∣V∣).
 *
 * https://leetcode.com/problems/course-schedule/discuss/1124408/Clearly-Explained-Solution-or-1ms-or-JAVA-or-DFS
 */
import java.util.*;
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create Array of lists -> adjecency matrix of graph
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        // Fill all the nodes (0 to numCourses - 1) as array index holding newly created arraylists
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Fill the arraylists of each nodes with their outgoing edges/connected nodes
        for(int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }

        // Define an array of visited (0 -> unvisited, 1 -> visited, 2 -> completed), initially filled with 0's
        int[] visited = new int[numCourses];

        // Do DFS for each of the array nodes to check a cycle
        for(int i=0; i<numCourses; i++) {
            if( !dfs(i, visited, adj))
                return false;
        }

        return true;
    }

    public boolean dfs(int node, int[] visited, ArrayList<Integer>[] adj) {
        // Return false if the node is visited and viewed again before completion
        if(visited[node] == 1) {
            return false;
        }

        // Return true if the node is completed processing
        if(visited[node] == 2) {
            return true;
        }

        // Mark the node as visited
        visited[node] = 1;

        // DFS of all the other nodes current "node" is connected to
        for(int n : adj[node]) {
            if(!dfs(n, visited, adj))
                return false;
        }

        // If no more other nodes for the current "node" mark as completed and return true

        visited[node] = 2;

        return true;
    }
}
