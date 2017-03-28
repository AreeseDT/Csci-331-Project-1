

import java.util.*;

/**
 * Created by adam on 3/27/17.
 */
public class Backtracking {

    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage: Backtracking <inputfile.txt>");
            System.exit(-1);
        }
        Graph campus = InputReader.readGraphFile(args[0]); //Read file and construct graph

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a starting point:");
        String start = input.nextLine().toUpperCase();
        while(!campus.containsNode(start)) {
            System.out.print(start);
            System.out.println(" is not a valid starting point.");
            start  = input.nextLine().toUpperCase();
        }

        System.out.println("Enter an ending point:");
        String end = input.nextLine().toUpperCase();
        while(!campus.containsNode(end)) {
            System.out.print(end);
            System.out.println(" is not a valid ending point.");
            end  = input.nextLine().toUpperCase();
        }

        ArrayList<String> path = new ArrayList<>(); //the list to hold the path
        int i = 0; //accumulator for total weight
        solveBacktracking(start, end, campus, i, path, new ArrayList<String>());
        path.add(start);
        //Reverse the path list because its in the reverse order we visited the nodes in
        Collections.reverse(path);

        //Print the path
        System.out.printf("%-20s %s%n", "Path:", String.join(" -> ", path));
    }

    /**
     * Uses recursive backtracking to find the path from a start node to an end node
     * @param currNode the node the algorithm is currently at
     * @param finalNode the destination node
     * @param graph the graph to search through
     * @param totalCost the total cost of the path
     * @param path the list of nodes in the path
     * @param visited List that contains all the nodes that have already been visited
     * @return true if a solution is found, false otherwise
     */
    private static boolean solveBacktracking(String currNode, String finalNode, Graph graph, int totalCost, ArrayList<String> path, ArrayList<String> visited){
        //Marking as visited so we don't cycle forever
        visited.add(currNode);
        //if the currNode is the destination then end.
        if (currNode.equals(finalNode)){
            System.out.printf("%-20s %d%n", "Total Weight:", totalCost);
            return true;
        }
        else {
            //Go through each child and attempt to generate a path to the destination
            for (Node n : graph.adjacencyList.get(currNode)){
                //If we haven't visited the node already and the subtree is solved correctly add this node to the path
                if (!visited.contains(n.name) && solveBacktracking(n.name, finalNode, graph, totalCost + n.weight, path, visited)){
                    path.add(n.name);
                    return true;
                }
            }
            //return false if no solution was found from this current node
            return false;
        }
    }
}
