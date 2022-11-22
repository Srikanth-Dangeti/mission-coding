package GrabTrees;
class BoundaryTraversal
{

    static Node root;
    public BoundaryTraversal()
    {
        root=null;
    }
   static  void printLeaves(Node node)  
    { 
        if (node != null)  
        { 
            printLeaves(node.left); 
   
            // Print it if it is a leaf node 
            if (node.left == null && node.right == null) 
                System.out.print(node.data + " "); 
            printLeaves(node.right); 
        } 
    } 
  static  void printBoundaryLeft(Node node)  
    { 
        if (node != null)  
        { 
            if (node.left != null)  
            { 
                   
               
                System.out.print(node.data + " "); 
                printBoundaryLeft(node.left); 
            }  
            else if (node.right != null)  
            { 
                System.out.print(node.data + " "); 
                printBoundaryLeft(node.right); 
            } 
   
            
        } 
    } 
   static void printBoundaryRight(Node node)  
    { 
        if (node != null)  
        { 
            if (node.right != null)  
            { 
                
                printBoundaryRight(node.right); 
                System.out.print(node.data + " "); 
            }  
            else if (node.left != null)  
            { 
                printBoundaryRight(node.left); 
                System.out.print(node.data + " "); 
            } 
            
        } 
    } 
    public static void printBoundary(Node node)
    {
        if(node!=null)
        {
            System.out.print(node.data+" ");
            printBoundaryLeft(node.left);
            printLeaves(node.left); 
            printLeaves(node.right); 
            printBoundaryRight(node.right); 
        }
        
    }
    public static void main(String[] args) 
    {
        
        BoundaryTraversal tree=new BoundaryTraversal();
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
        tree.root.right.right = new Node(25); 
        printBoundary(root); 


    }
}