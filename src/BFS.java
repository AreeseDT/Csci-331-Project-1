import java.util.Scanner;

/**
 * Created by adam on 3/27/17.
 */
public class BFS {

    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage: BFS <inputfile.txt>");
            System.exit(-1);
        }

        Graph campus = InputReader.readGraphFile(args[0]);

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a starting point:");
        String start = input.nextLine();
        while(!campus.containsNode(start)) {
            System.out.print(start);
            System.out.println(" is not a valid starting point.");
            start  = input.nextLine();
        }

        System.out.println("Enter an ending point:");
        String end = input.nextLine();
        while(!campus.containsNode(end)) {
            System.out.print(end);
            System.out.println(" is not a valid ending point.");
            end  = input.nextLine();
        }

    }

}
