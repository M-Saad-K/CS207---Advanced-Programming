package practical8;

import java.util.*;

/**
 * An interface for a simple undirected, unweighted graph, for use in CS207.
 * No node data is maintained. Nodes are numbered from 0.
 *
 */

public interface GraphADT
{ 
    /** the number of nodes in the graph
    @return returns the number of nodes in the graph
    */
    int nNodes();
 
    /** the number of edges in the graph
    @return returns the number of edges in the graph
    */
    int nEdges();
 
    /** Adds an edge between nodes node1 and node2
    If the edge is already present in the graph it should not be duplicated
    and the method should return false. Otherwise the edge should be added 
    and the method should return true.
    @param node1 one node
    @param node2 another node
    @return  returns true if the edge was not already present. Otherwise 
    returns false.
    */
    boolean addEdge(int node1, int node2);

    /** true if there is an edge between nodes node1 and node2
    @param node1 one node
    @param node2 another node
    @return returns true iff there is an edge between nodes node1 and node2
    */
    boolean isEdge(int node1, int node2);

    /** The neighbours of a given node in the graph
    @param node a node in the graph
    @return returns an ArrayList of Integers (the node numbers) which represent the neighbours
    nodes of the given node
    */
    ArrayList<Integer> neighbours(int node);


    /** Performs a Depth-First Search starting from a given node
     @param startNode the starting node
     @return a list of nodes in the order they were visited
     */
    List<Integer> dfs(int startNode);

    /** Performs a Breadth-First Search starting from a given node
     @param startNode the starting node
     @return a list of nodes in the order they were visited
     */
    List<Integer> bfs(int startNode);
}

