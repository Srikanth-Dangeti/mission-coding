package googleInterviewQuestion.Monday;

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

public class SecuredLinkedList {
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
