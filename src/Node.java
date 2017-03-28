import java.util.Comparator;

/**
 * Class to hold the data in the adjacency list, holds the name of the vertex and the weight
 * of the connection
 */
public class Node implements Comparable<Node>{
    public String name;
    public int weight;

    public Node(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        if (this.weight > o.weight) return 1;
        if (this.weight < o.weight) return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        Node node = (Node)obj;
        return this.name.equals(node.name) && this.weight == node.weight;
    }
}
