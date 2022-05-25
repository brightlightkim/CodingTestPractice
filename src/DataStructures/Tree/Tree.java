package DataStructures.Tree;

import java.util.Queue;

public class Tree {
    class Node {
        public String name;
        public Node left;
        public Node right;
    }

    public Node root;

    void inOrderTraversal(Node node) {
        if (node != null){
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(Node node) {
        if (node != null){
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(Node node) {
        if (node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

    void DFS_Search(Node root) {
        if (root == null) return;
        visit(root);
        root.visited = true;
        for each (Node n in root.adjacent) {
            if (n.visited == false) {
                search(n);
            }
        }
    }

    void BFS_Search(Node root) {
        Queue queue = new Queue();
        root.marked = true;
        queue.enqueue(root); // Add to the end of queue

        while (!queue.isEmpty()) {
            Node r = queue.dequeue(); // Remove from the front of the queue
            visit(r);
            foreach (Node n in r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
        }
    }
}
