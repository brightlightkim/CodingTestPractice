package DataStructures.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Node {
    Node next = null;
    int data;

    public Node(int value) {
        data = value;
    }

    public void insertNodeAtTail(int value) {
        Node newNode = new Node(value);
        Node n = this;
        while (n.next != null) {
            n = n.next;
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

        while(n.next != null){
            if (set.contains(n.next.data)){
                // It means it already exists.
                if (n.next.next != null) {
                    n.next = n.next.next;
                } else {
                    n.next = null;
                    break;
                }
            } else {
                set.add(n.next.data);
            }
            n = n.next;
        }
        return head;
    }

    public void deleteDups(Node n) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        while (n!=null){
            if (set.contains(n.data)){
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
        }
    }

    public void printNodes(){
        Node n = this;
        while(n.next!=null){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }
}
