import java.util.*;

/**
 * Created by adam on 3/27/17.
 */
public class BFS {

    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage: BFS <inputfile.txt>");
            System.exit(-1);
        }

        Graph graph = InputReader.readGraphFile(args[0]);

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a starting point:");
        String start = input.nextLine().toUpperCase();
        while(!graph.containsNode(start)) {
            System.out.print(start);
            System.out.println(" is not a valid starting point.");
            start  = input.nextLine();
        }

        System.out.println("Enter an ending point:");
        String end = input.nextLine().toUpperCase();
        while(!graph.containsNode(end)) {
            System.out.print(end);
            System.out.println(" is not a valid ending point.");
            end  = input.nextLine();
        }

        HashMap<String, Node> pathMap = bfs(graph, start, end);
        if(pathMap == null) {
            System.out.println("No path found.");
            System.exit(-1);
        }

        printPath(pathMap, end);

    }

    /**
     * Searches for a path from start to end using breadth first search
     *
     * @param graph The graph to search
     * @param start Name of the starting location
     * @param end Name of the ending location
     * @return Map used to rebuild the path
     */
    public static HashMap<String, Node> bfs(Graph graph, String start, String end) {
        HashMap<String, Node> pathMap = new HashMap<>();

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        ArrayList<String> visited = new ArrayList<>();
        Node node;

        while(!queue.isEmpty()) {
            node = queue.poll();
            visited.add(node.name);

            if(node.name.equals(end)) {
                return pathMap;
            }

            for(Node n : graph.adjacencyList.get(node.name)) {
                if(!visited.contains(n.name)) {
                    queue.add(n);
                    pathMap.put(n.name, new Node(node.name, n.weight));
                }
            }
        }

        return null;
    }

    /**
     * Rebuilds the path and outputs it to the console
     *
     * @param map The path information produced from the bfs search
     * @param end Name of the ending location
     */
    public static void printPath(HashMap<String, Node> map, String end) {
        List<String> path = new ArrayList<>();
        path.add(end);

        int cost = 0;

        Node node;

        while(map.containsKey(end)) {
            node = map.get(end);
            cost += node.weight;
            end = node.name;
            path.add(end);
        }
        Collections.reverse(path);
        System.out.println("Total weight: " + cost);

        path.forEach(System.out::println);
    }

}
