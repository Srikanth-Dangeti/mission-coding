package googleInterviewQuestion.Monday;

import java.util.*;

/***
 *
 */
public class FindStringInHtmlDom {

    interface INode {
        List<INode> GetAllChildren();
        String getText();
        INode getParent();
    }

    static class Node implements INode {

        public INode parent;
        public String text;
        public List<INode> children;

        public Node(String text, List<INode> children) {
            this.text = text;
            this.children = children;
            this.parent = null; // not needed
        }

        @Override
        public List<INode> GetAllChildren() {
            return children;
        }

        @Override
        public String getText() {
            return text;
        }

        @Override
        public INode getParent() {
            return parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "parent=" + parent +
                    ", text='" + text + '\'' +
                    ", children=" + children +
                    '}';
        }
    }

    public List<INode> findStringInDOM(String searchString, INode root) {
        List<INode> leafs = findLeafs(root);
        StringBuilder builder = new StringBuilder();
        TreeMap<Integer, INode> textNodeByStartPos = new TreeMap<>();
        int pos = 0;

        for(INode leaf : leafs) {
            assert leaf.getText() != null;
            builder.append(leaf.getText());
            textNodeByStartPos.put(pos, leaf);
            pos += leaf.getText().length();
        }

        int matchBeginAt = builder.indexOf(searchString);
        if(matchBeginAt == -1) {
            return Collections.emptyList();
        }
        int matchEndAt = matchBeginAt + searchString.length();
        Integer left = textNodeByStartPos.floorKey(matchBeginAt); // return first key that is less or equal
        left = left == null ? 0 : left;
        Integer right = textNodeByStartPos.ceilingKey(matchEndAt); // return first key that is greater or equal
        right = right == null ? textNodeByStartPos.lastKey() : right;

        List<INode> results = new ArrayList<>();
        for(int i = left; i <= right && i <= matchBeginAt + searchString.length();) {
            results.add(textNodeByStartPos.get(i));
            int nextKey = i + textNodeByStartPos.get(i).getText().length();
            i = nextKey;
        }
        return results;
    }

    // simple dfs to find all leafs and concat them from left to right
    private List<INode> findLeafs(INode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.GetAllChildren() == null || root.GetAllChildren().isEmpty()) {
            return Collections.singletonList(root);
        }
        List<INode> leafs = new ArrayList<>();
        for(INode child : root.GetAllChildren()) {
            leafs.addAll(findLeafs(child));
        }
        return leafs;
    }

    public static void main(String[] args) {
        INode thisText = new Node("This", null);
        INode isText = new Node("is", null);
        INode funText = new Node("fun", null);
        INode b = new Node(null, Collections.singletonList(thisText));
        INode i = new Node(null, Collections.singletonList(funText));
        List<INode> children = new ArrayList<>();
        children.add(b);
        children.add(isText);
        children.add(i);
        INode div = new Node(null, children);

        runIt("hisi", div);
        runIt("this", div);
        runIt("hisisf", div);
        runIt("hisisfun", div);
        runIt("hisisfunist", div);
    }

    static int textCounter = 1;
    private static void runIt(String search, INode root) {
        FindStringInHtmlDom sol = new FindStringInHtmlDom();
        List<INode> result = sol.findStringInDOM(search, root);
        System.out.println("Result #" + (textCounter++) + ": " + result);
    }
}