import DataStructures.LinkedList.Node;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    // Insert Nodes
        Node node = new Node(1);
        node.insertNodeAtTail(2);
        node.insertNodeAtTail(3);
        node.insertNodeAtTail(2);

        node = node.returnKthToLast(node, 2);

        node.printNodes();
    }
}
