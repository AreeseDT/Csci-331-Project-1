import java.util.*;

/**
 * Created by adam on 3/27/17.
 */
public class AStar {

    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage: AStar <inputfile.txt>");
            System.exit(-1);
        }

        Graph campus = InputReader.readGraphFile(args[0]); //Read file and construct graph

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a starting point:");
        String start = input.nextLine().toUpperCase();
        while(!campus.containsNode(start)) {
            System.out.print(start);
            System.out.println(" is not a valid starting point.");
            start  = input.nextLine();
        }

        System.out.println("Enter an ending point:");
        String end = input.nextLine().toUpperCase();
        while(!campus.containsNode(end)) {
            System.out.print(end);
            System.out.println(" is not a valid ending point.");
            end  = input.nextLine();
        }

        List<String> path = getPath(aStar(start, end, campus), end);
        path.forEach(System.out::println);

    }

    /**
     * Runs the A* search algorithm on the Graph
     * @param start the start node
     * @param end the end node
     * @param graph the graph
     * @return a mapping that the path and total cost can be determined from
     */
    public static HashMap<String, Node> aStar(String start, String end, Graph graph){
        ArrayList<String> visited = new ArrayList<>();
        Queue<Node> queue = new PriorityQueue<Node>(); //Using priority queue to auto sort the nodes by least cost
        Node current;
        queue.add(new Node(start, Integer.MAX_VALUE)); //Start first node at max value in queue so its updated quickly
        HashMap<String, Node> pathMap = new HashMap<>();

        while(!queue.isEmpty()){
            current = queue.poll();
            visited.add(current.name);
            //if we're at the current node then return the mapping
            if (current.name.equals(end)){
                return pathMap;
            }

            //Go through each child node and determine if they are less cost based on the heuristic
            for (Node n : graph.adjacencyList.get(current.name)){
                if (visited.contains(n.name)) continue; //If already visited, skip

                //Compare the child's cost plus its heuristic to the current node's cost
                if ((n.weight + graph.heuristicValues.get(n.name)) < current.weight || !queue.contains(n)){
                    //Adding a new node with a weight that is the heuristic value plus the path weight
                    queue.add(new Node(n.name, n.weight + graph.heuristicValues.get(n.name)));
                    pathMap.put(n.name, new Node(current.name, n.weight));
                }
            }
        }
        return null;
    }

    /**
     * Gets the path as a list based on the mapping
     * @param map the mapping produced from astar
     * @param end the final node
     * @return a list that is the path in order
     */
    private static List<String> getPath(HashMap<String, Node> map, String end){
        List<String> path = new ArrayList<>();
        path.add(end);
        Node n;
        int totalWeight = 0;
        while (map.containsKey(end)){
            n = map.get(end);
            end = n.name;
            totalWeight += n.weight;
            path.add(end);
        }
        Collections.reverse(path);
        System.out.println("Total weight: " + totalWeight);
        return path;
    }
}
