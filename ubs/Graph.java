package code_practice.ubs;//Java code for Breadth First Traversal
import java.util.LinkedList;
import java.util.Queue;
class Vertex {
    char label;
    boolean visited;
    public Vertex(char label) {
        this.label = label;
        visited = false;
    }
}
public class Graph {
    private static final int MAX = 6;
    private Vertex[] lstVertices;
    private int[][] adjMatrix;
    private int vertexCount;
    public Graph() {
        lstVertices = new Vertex[MAX];
        adjMatrix = new int[MAX][MAX];
        vertexCount = 0;
    }
    private void addVertex(char label) {
        Vertex vertex = new Vertex(label);
        lstVertices[vertexCount++] = vertex;
    }
    private void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    private void displayVertex(int vertexIndex) {
        System.out.print(lstVertices[vertexIndex].label + " ");
    }
    private int getAdjUnvisitedVertex(int vertexIndex) {
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[vertexIndex][i] == 1 && !lstVertices[i].visited)
                return i;
        }
        return -1;
    }
    private void breadthFirstSearch() {
        lstVertices[0].visited = true;
        displayVertex(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int tempVertex = queue.poll();
            int unvisitedVertex;
            while ((unvisitedVertex = getAdjUnvisitedVertex(tempVertex)) != -1) {
                lstVertices[unvisitedVertex].visited = true;
                displayVertex(unvisitedVertex);
                queue.add(unvisitedVertex);
            }
        }
        // Reset the visited flag
        for (int i = 0; i < vertexCount; i++) {
            lstVertices[i].visited = false;
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph();
//        MAX = 5;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++)
                graph.adjMatrix[i][j] = 0;
        }
        graph.addVertex('0');   // 0
        graph.addVertex('1');   // 1
        graph.addVertex('2');   // 2
        graph.addVertex('3');   // 3
        graph.addVertex('4');   // 4
        graph.addVertex('5');   // 5

        graph.addEdge(0, 5);    // S - A
        graph.addEdge(0, 4);    // S - B
        graph.addEdge(4, 5);    // S - C
        graph.addEdge(5, 1);    // A - D
        graph.addEdge(4, 1);    // B - D
        graph.addEdge(4, 2);    // C - D
        graph.addEdge(2, 3);    // C - D

//        graph.addVertex('0');   // 0
//        graph.addVertex('1');   // 1
//        graph.addVertex('2');   // 2
//        graph.addVertex('3');   // 3
//        graph.addVertex('4');   // 4
////        graph.addVertex('5');   // 5
//
//        graph.addEdge(0, 1);    // S - A
//        graph.addEdge(0, 2);    // S - B
//        graph.addEdge(1, 2);    // S - C
//        graph.addEdge(1, 3);    // A - D
//        graph.addEdge(3, 4);    // B - D
//        graph.addEdge(4, 2);    // C - D
//        graph.addEdge(2, 3);    // C - D

        System.out.print("Breadth First Search: ");
        graph.breadthFirstSearch();
    }
}