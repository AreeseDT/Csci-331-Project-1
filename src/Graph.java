/**
 * Nick Marchionda - Graph.java
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
/**
 * Class used to represent a graph and it's vertices using an adjacency list and matrix
 */
public class Graph{

    private static final int NOT_CONNECTED_VALUE = 0; //The value that represents a non-connection in the adjacency matrix

    //the adjacency list used to represent the graph
    private HashMap<String, ArrayList<Node>> adjacencyList;
    
    /**
     * The constructor for the graph class.
     *
     */
    public Graph(){
        this.adjacencyList = new HashMap<String, ArrayList<Node>>();
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
