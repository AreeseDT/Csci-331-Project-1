Intro to Intelligent Systems - Project 1

Nick Marchionda and Adam Reese

Running the program:
-Java Version 8
-Each search has a separate main file
    -Breadth-First Search -> BFS.java
    -A* Search -> AStar.java
    -Backtracking Search -> Backtracking.java
-Compile with javac <Main filename>
-Run with java <Main program> <graph_file.txt>
-The path and total weight will be outputted to standard out

Graph File Format:
-The file format is specified in doc/input_file_format.txt
-Each file has both the graph data and the heuristic data in the same file

Heuristics:
-RITGraphHeuristic1.txt is the graph with the heuristic that was given to us for finding GOL
-RITGraphHeuristic2.txt is the graph with a heuristic that we came up with that is for finding GOL
-RITGraphHeuristic3.txt is the graph with a heuristic to find the node WAL