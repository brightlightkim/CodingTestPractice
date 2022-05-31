package DataStructures.Graph;

import java.util.LinkedList;

public class Graph {
    public Node[] nodes;
    public Node[] getNodes(){
        return nodes;
    }
}

class Node {
    public String name;
    public Node[] children;
}

enum State { Unvisited, Visited, Visiting };

public boolean search (Graph g, Node start, Node end){
    if (start == end) return ture;

    // operates as Queue
    LinkedList<Node> q = new LinkedList<>();
    for (Node u: g.getNodes()){
        u.state = State.Visiting;
    }
    start.state = State.Visiting;
    q.add(start);
    Node u;
    while (!q.isEmpty()) {
        u = q.removeFirst(); // i.e., dequeue()
        if (u != null){
            for (Node v: u.getAdjacent()) {
                if (v.state == State.Unvisited) {
                    if (v == end) {
                        return true;
                    } else{
                        v.state = State.Visiting;
                        q.add(v);
                    }
                }
            }
            u.state = State.Visited;
        }
    }
    return false;
}
