import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by nicmarr on 3/26/2017.
 */
public class InputReader {

    public static Graph readGraphFile(String filename){
        Graph graph = new Graph();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null){
                if (line.charAt(0) == 'e'){
                    String[] strArray = line.split("\\s+");
                    if (strArray.length != 4){
                        System.out.println("Error in graph input file: edge lines should have 3 parameters");
                        System.exit(-1);
                    }
                    graph.addEdge(strArray[1], strArray[2], Integer.parseInt(strArray[3]));
                }
                else if(line.charAt(0) == 'h'){
                    String[] strArray = line.split("\\s+");
                    if (strArray.length != 3) {
                        System.out.println("Error in graph input file: heuristic lines should have 2 parameters");
                        System.exit(-1);
                    }
                    graph.addHeuristicValue(strArray[1], Integer.parseInt(strArray[2]));
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
	return graph;
    }
}
