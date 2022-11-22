package Google2020Series;

/**
 *  https://leetcode.com/problems/clone-graph/
 *  Time Complexity : O(N + M) , where N is s number of nodes(vertices) and M is the no of edges.
 *  Space Complexity : O(N) :This space is occupied by the visited hash map and in addition to that,
 *  space would also be occupied by the recursion stack since we are adopting a recursive approach here.
 *  The space occupied by the recursion stack would be equal to
 * O(H) where H
 * H is the height of the graph. Overall, the space complexity would be O(N).
 */
import java.util.*;

class CloneGraphNode {
    public int val;
    public List<CloneGraphNode> neighbors;
    public CloneGraphNode() {
        val = 0;
        neighbors = new ArrayList<CloneGraphNode>();
    }
    public CloneGraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<CloneGraphNode>();
    }
    public CloneGraphNode(int _val, ArrayList<CloneGraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {

    HashMap<Integer, CloneGraphNode> hmap = new HashMap<>();

    public CloneGraphNode cloneGraph(CloneGraphNode root)
    {
        if(root == null)
            return null;

        if(hmap.containsKey(root.val))
            return hmap.get(root.val);

        CloneGraphNode newNode = new CloneGraphNode(root.val, new ArrayList<CloneGraphNode>());

        hmap.put(root.val, newNode);
        for(CloneGraphNode neighbor : root.neighbors)
        {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }
}
