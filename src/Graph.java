import java.util.*;

/**
 * Class used to represent a graph and it's vertices using an adjacency list and matrix
 */
public class Graph{

    //the adjacency list used to represent the graph
    public HashMap<String, ArrayList<Node>> adjacencyList;
    public HashMap<String, Integer> heuristicValues;
    
    /**
     * Constructor
     */
    public Graph(){
        this.adjacencyList = new HashMap<String, ArrayList<Node>>();
        this.heuristicValues = new HashMap<String, Integer>();
    }

    /**
     * Adds an edge to the adjacency list of the graph. Adds it to both the start and end nodes
     * @param startNode the first node of the edge
     * @param endNode the second node of the edge
     * @param weight the weight of the connection
     */
    public void addEdge(String startNode, String endNode, int weight) {
        //Making sure the ArrayList is initialized before adding to it.
        if (this.adjacencyList.get(startNode) == null){
            this.adjacencyList.put(startNode, new ArrayList<Node>());
        }
        //Adding the edge from the start to the end
        this.adjacencyList.get(startNode).add(new Node(endNode, weight));

        //Making sure the ArrayList is initialized before adding to it.
        if (this.adjacencyList.get(endNode) == null){
            this.adjacencyList.put(endNode, new ArrayList<Node>());
        }
        //Adding the edge from the end to the start
        this.adjacencyList.get(endNode).add(new Node(startNode, weight));
    }

    /**
     * Associates a value with a node for the heuristic used in A*
     * @param nodeName the node
     * @param value the value associated with the node
     */
    public void addHeuristicValue(String nodeName, int value){
        this.heuristicValues.put(nodeName, value);
    }

    public void displayEdges(){
        for (Map.Entry<String, ArrayList<Node>> entry : this.adjacencyList.entrySet()){
            System.out.println("Node " + entry.getKey() + " has edges:");
            for (Node n:entry.getValue()) {
                System.out.println(n.name + ": " + n.weight);
            }
        }
    }

    public boolean containsNode(String node) {
        for (Map.Entry<String, ArrayList<Node>> entry : this.adjacencyList.entrySet()) {
            if(entry.getKey().equals(node)) return true;
            for (Node n : entry.getValue()) {
                if(n.name.equals(node)) return true;
            }
        }
        return false;
    }

    /**
     * Class to hold the data in the adjacency list, holds the name of the vertex and the weight
     * of the connection
     */
    private class Node{
        public String name;
        public int weight;

        private Node(String name, int weight){
            this.name = name;
            this.weight = weight;
        }
    }
   
}
