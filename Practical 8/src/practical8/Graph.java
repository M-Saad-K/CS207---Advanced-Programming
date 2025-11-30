/**
* @ Author: Muhammad Saad Khan
* @ Date: 2025 / 11 / 30
* @ Title: Graph.java
**/
package practical8;
import java.util.*;
/**
 * Implementation of the GraphADT interface using an adjacency list with LinkedLists.
 */
class Graph implements GraphADT {
    private int nNodes; // Number of nodes
    private int nEdges; // Number of edges
    private List<LinkedList<Integer>> adjacencyList; // Adjacency list representation

    public Graph(int nodes) {
        this.nNodes = nodes;
        this.nEdges = 0;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    @Override
    public int nNodes() {
        return nNodes;
    }

    @Override
    public int nEdges() {
        return nEdges;
    }

    @Override
    public boolean addEdge(int node1, int node2) {
        if (node1 < 0 || node1 >= nNodes || node2 < 0 || node2 >= nNodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }
        if (adjacencyList.get(node1).contains(node2)) {
            return false; // Edge already exists
        }
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1); // Because the graph is undirected
        nEdges++;
        return true;
    }

    @Override
    public boolean isEdge(int node1, int node2) {
        if (node1 < 0 || node1 >= nNodes || node2 < 0 || node2 >= nNodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }
        return adjacencyList.get(node1).contains(node2);
    }

    @Override
    public ArrayList<Integer> neighbours(int node) {
        if (node < 0 || node >= nNodes) {
            throw new IllegalArgumentException("Invalid node index");
        }
        return new ArrayList<>(adjacencyList.get(node));
    }

    @Override
    public List<Integer> dfs(int startNode) {
        if (startNode < 0 || startNode >= nNodes) {
            throw new IllegalArgumentException("Invalid start node");
        }

        // Make a stack for the integers
        Stack<Integer> stack = new Stack<>();
        // Will hold the visiting order of elements
        ArrayList<Integer> visitedOrder = new ArrayList<>();
        // Make an array of booleans and make it the size of the numbers
        boolean[] visited = new boolean[nNodes];
        stack.push(startNode); // Push first element into the stack
        visited[startNode] = true; // Make that first element true
        // These nodes are the vertices
        while (!stack.isEmpty()) {

            int currentNode = stack.pop();
            visitedOrder.add(currentNode);
            System.out.println(currentNode+" ");
            for (int neighbor : adjacencyList.get(currentNode)) {
                // Places the adjaceny list of the current node in the neighbour
                if (!visited[neighbor]) {
                    // If the neighbor has not yet passed
                    stack.push(neighbor); // Put the name on the stack
                    visited[neighbor] = true;
                    /// The stack is used to hold unvisited variables
                }
            }
        }
        // Return the visiting order, how will we do that, by creating another arraylist, that will hold each visited order element
        return visitedOrder;
    }

    @Override
    public List<Integer> bfs(int startNode) {
        if (startNode < 0 || startNode >= nNodes) {
            throw new IllegalArgumentException("Invalid start node");
        }
        boolean[] visited = new boolean[nNodes];
        ArrayList<Integer> visitedOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visitedOrder.add(currentNode);
            System.out.println(currentNode+" ");
            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return visitedOrder;
    }
}

/**
 * Test class for the Graph implementation.
 */
class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5); // A graph with 5 nodes
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        

        System.out.println("Number of nodes: " + graph.nNodes());
        System.out.println("Number of edges: " + graph.nEdges());

        System.out.println("DFS starting from node 0: " + graph.dfs(0));
        System.out.println("BFS starting from node 0: " + graph.bfs(0));
    }
}

