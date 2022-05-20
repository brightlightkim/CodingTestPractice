package DataStructures.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Node {
    Node next = null;
    int data;

    public Node(int value) {
        data = value;
    }

    void insertNodeAtTail(int value) {
        Node newNode = new Node(value);
        Node n = this;
        while (n.next != null) {
            n = n;
        }
        n.next = newNode;
    }

    public Node deleteNode(Node head, int value) {
        Node n = head;
        if (n.data==value){
            return head.next;
        }

        while (n.next.next != null){
            if (n.next.data == value){
                n.next = n.next.next;
                return head; //head doesn't change
            }
            n = n.next;
        }
        return head;
    }

    public Node deleteDuplicatedNodes(Node head){
        Node n = head;
        Set<Integer> set = new HashSet<>();
        set.add(n.data);

        while(n.next.next != null){
            if (!set.add(n.next.data)){
                // It means it already exists.
            }
        }
        return head;
    }
}
