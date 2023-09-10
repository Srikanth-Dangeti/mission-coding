package googleInterviewQuestion;


/***
 * A normal Linked List looks like this Node - Node -> Node, and a Node is usually represented as Node(String value,
 * Node next).
 * The Linkedlist Node used in this question is a little bit special. It has one more field which is an integer
 * hashValue. lie. Node(String value; Node next: int hashValue).
 * The hashValue of a Node should be the hash of "its own value concatenated with the hashValue of the next node.
 * You can assume there is already a hash function well defined. The hash function implementation is not important
 * for this question. If the Node do not have a next Node, its hashValue should be the hash of the Node's own value
 * Now we want you to define and implement a Secured Linked List class which h&s the following two interfaces,
 * 1. void addvalue (String value) which adds a new node with the value at the head" of the Linked List. Note:
 * This is different from a normal.
 * Linked List which always adds new node to the tail.
 * 2. boolean isValidChain() which returns true if the whole chain is valid, false if not. "Valid* means for every node,
 * the hashValue is in compliance with the hash function, i.e. hashValue is the same as the hash of "its own value
 * concatenated with the hashValue of the next node"
 * (After the candidate finish coding for the data structure above, please ask the question below.)
 * Now assume you are a hacker who wants to hack the chain by inserting a new value into a position
 * (head is at position 0). And the chain is still valid after the hack. Please implement the hack function with the
 * following interface
 * void hack(String value, int pos, SecuredLinkedtist chain)
 * Note: hack) is not able to access the SecuredLinkedList if the head node is private. So the interviewer needs to
 * tell the candidate they can assume the head is public when writing the hack function. If the interviewer has
 * concerns on describing it, this question can be replaced by insert(value, pos) function instead, Same problem,
 * but doesn't raise the questions about access control violations
 *
 *
 * Background
 * Let the candidate know they can assume the following
 * There is already a hash function well defined. E.g. SHA512
 * Follow Up Question #1: Test cases
 * Please talk about test cases of the interfaces Secured Linked List.
 * Follow Up Question #2: Construct the Secured Linked List from a plain linked list
 * (This follow-up is contributed by afoglia@ as a comment in go/iq/2833)
 * Take a plain LinkedList and return a SecuredLinkedList with all the hashes computed.
 * Follow Up Question #3: Cycle check
 * Now let's assume adavalue is not the only method that can
 * manipulates the SecuredLinkedList, the code may have bug;
 * there might be hackers, etc. So 1svalidcha in needs to consider more scenarios to protect the
 * SecuredLinkedList. What kind of improvements do you want to make to let isvalidchain
 * protecomore corner cases
 * If the candidate still has no clue, let them know a cycle may break their isValid method,
 * and let them implement a cycle-safe isvalld method
 *
 *
 *
 *  Follow Up Question #2: Construct the Secured Linked List from a plain linked list
 *  Below
 *  To construct a SecuredLinkedList from a plain linked list, you would need to create a new instance of
 *      SecuredLinkedList and iterate through the nodes of the plain linked list, adding each node's value to the
 *      new SecuredLinkedList. The hashValue of each node in the SecuredLinkedList should be calculated based on
 *      the value and the hashValue of the next node, just as described in your previous implementation.
 *           Here's a step-by-step guide on how to construct a SecuredLinkedList from a plain linked list:
 *           Create a new instance of SecuredLinkedList.
 *           Iterate through the nodes of the plain linked list.
 *           For each node in the plain linked list, add its value to the SecuredLinkedList using the
 *      addValue method. This will automatically calculate and set the hashValue for each node in the SecuredLinkedList.
 *           class Node {
 *          String value;
 *          Node next;
 *               public Node(String value, Node next) {
 *              this.value = value;
 *              this.next = next;
 *          }
 *      }
 *           class SecuredLinkedList {
 *          public Node head;
 *               public SecuredLinkedList() {
 *              this.head = null;
 *          }
 *               public void addValue(String value) {
 *              head = new Node(value, head);
 *          }
 *               // Other methods, such as isValidChain and hack, from your previous implementation
 *               // ...
 *               public static SecuredLinkedList fromPlainLinkedList(Node plainHead) {
 *              SecuredLinkedList securedList = new SecuredLinkedList();
 *                   Node current = plainHead;
 *                   while (current != null) {
 *                  securedList.addValue(current.value);
 *                  current = current.next;
 *              }
 *                   return securedList;
 *          }
 *      }
 *           The fromPlainLinkedList method takes the head of a plain linked list as an input parameter and constructs a
 *      SecuredLinkedList by iterating through the nodes of the plain linked list and adding their values to the new
 *      SecuredLinkedList. The addValue method takes care of calculating and setting the hashValue for each node.
 *      You can use the fromPlainLinkedList method to convert a plain linked list into a SecuredLinkedList and then
 *      work with the secured version of the list.
 *
 *
 * Time Complexity:
 *
 * addValue(String value):
 *
 * Time Complexity: O(1)
 * Explanation: Adding a new value at the head of the linked list involves creating a new node and updating the head.
 * These operations are constant time.
 * isValidChain():
 *
 * Time Complexity: O(n)
 * Explanation: Checking the validity of the entire chain involves iterating through all nodes in the linked list once,
 * where 'n' is the number of nodes.
 * hack(String value, int pos, SecuredLinkedList chain):
 *
 * Time Complexity: O(n) in the worst case
 * Explanation: Inserting a value at a specific position requires traversing the list to find the predecessor node at
 * position 'pos-1'. In the worst case, this involves iterating through 'n' nodes.
 * Space Complexity:
 *
 * The addValue method has a space complexity of O(1) because it only involves creating a new node, which is independent
 * of the size of the linked list.
 *
 * The isValidChain method has a space complexity of O(1) because it uses a constant amount of additional space for
 * variables used in the loop.
 *
 * The hack method also has a space complexity of O(1) because it creates a new node and updates references, and the
 * additional space used is not dependent on the size of the linked list.
 *
 * Overall, the space complexity of the provided code is constant, O(1), because the memory used does not grow with the
 * size of the linked list. The time complexity is O(n) for the isValidChain and hack methods, where 'n' is the number
 * of nodes in the linked list, but the addValue method is constant time O(1).
 *
 *
 *
 *
 */

import java.util.Objects;

class Node {
    String value;
    int hashValue;
    Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
        this.hashValue = calculateHash();
    }

    public int calculateHash() {
        if (next == null) {
            return value.hashCode();
        } else {
            return (value + next.hashValue).hashCode();
        }
    }
}

class SecuredLinkedList {
    public Node head;

    public SecuredLinkedList() {
        this.head = null;
    }

    public void addValue(String value) {
        head = new Node(value, head);
    }

    public boolean isValidChain() {
        Node current = head;
        //Cycle code
        Node slowPtr = head;
        Node fastPtr = head;

        //while (fastPtr != null && fastPtr.next != null) {
        while (current != null) {
            int expectedHashValue = current.calculateHash();

            if (current.hashValue != expectedHashValue) {
                return false;
            }

            current = current.next;
            /*slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                // Cycle detected
                return false;
            }*/
        }

        return true;
    }

    public void hack(String value, int pos, SecuredLinkedList chain) {
        Node newNode = new Node(value, null);

        if (pos == 0) {
            // Insert at the beginning (head position)
            newNode.next = chain.head;
            newNode.hashValue = newNode.calculateHash();
            chain.head = newNode;
        } else {
            // Find the predecessor node at position pos-1
            Node predecessor = chain.head;
            for (int i = 0; i < pos - 1; i++) {
                predecessor = predecessor.next;
                if (predecessor == null) {
                    throw new IllegalArgumentException("Invalid position");
                }
            }

            // Insert the new node between the predecessor and its successor
            newNode.next = predecessor.next;
            newNode.hashValue = newNode.calculateHash();
            predecessor.next = newNode;

            // Update the hashValue of the predecessor node
            predecessor.hashValue = (predecessor.value + newNode.hashValue).hashCode();
        }
    }

    public static void main(String[] args) {
        SecuredLinkedList myList = new SecuredLinkedList();

        myList.addValue("C");
        myList.addValue("B");
        myList.addValue("A");

        // Creating a cycle for testing (C points back to B)
        myList.head.next.next.next = myList.head.next;

        System.out.println("Original Chain with Cycle:");
        System.out.println("Is Valid? " + myList.isValidChain());

        myList.hack("X", 1, myList);

        System.out.println("Hacked Chain with Cycle:");
        System.out.println("Is Valid? " + myList.isValidChain());
    }
}



