/**
 * 
 * @author krishna kumar
 * 
 *         This is a basic implementation of BFS for Graph using Adjacency list.
 *
 */
import java.util.Scanner;
public class Grafo {
    private int[][] adjacencyMatrix;
    private int size; // number of nodes in the graph
    private State[] states;
    private Queue queue;
    public Grafo(int size) {
        this.size = size;
        adjacencyMatrix = new int[size][size];// Initialized with all 0s
        states = new State[size];
        for (int i = 0; i < size; i++) {
            states[i] = State.NEW;
        }
        queue = new Queue(size);
    }

    // Añade las relaciones a la matriz (0 y 1)
    public void addEdge(int sourceName, int destinationName) {
        int sourceIndex = sourceName - 1;
        int destinationIndex = destinationName - 1;
        adjacencyMatrix[sourceIndex][destinationIndex] = 1;
        // the graph is non directional so if from S, D is reachable then vice
        // versa is also true
        adjacencyMatrix[destinationIndex][sourceIndex] = 1;
    }

    public void traverseGraph() {
        System.out.println("Using BFS Traversing the graph");

        for (int i = 0; i < size; i++) {
            if (states[i] != State.VISITED) {
                bfs(i+1);
            }
        }
    }

    private void bfs(int currentNodeName) {
        queue.add(currentNodeName);
        states[currentNodeName-1] = State.IN_Q;
        while(!queue.isEmpty()){
            int visitedNodeName = queue.remove();
            states[visitedNodeName-1] = State.VISITED;
            System.out.println(visitedNodeName);
            for(int i = 0; i < size; i++){
                if(adjacencyMatrix[visitedNodeName-1][i] != 0){
                    if(states[i] == State.NEW){
                        queue.add((i+1));
                        states[i] = State.IN_Q;
                    }
                }
            }
        }
    }

    public enum State {
        NEW, IN_Q, VISITED
    };

    /**
     * 
     * This is a simple queue implemented using array. Although ideally queue
     * should be implemented in circular style so as to use the empty area when
     * items are deleted from the front but for BFS implementation we each item
     * is added only once so if the size of the queue is taken as the size of
     * the items then there is no need for circular styled implementation.
     *
     */
    public class Queue {
        Integer[] queue;
        int maxSize;
        int front = -1,rear = -1;

        Queue(int maxSize) {
            this.maxSize = maxSize;
            queue = new Integer[maxSize];
        }

        public void add(int node) {
            queue[++rear] = node;
        }

        public int remove() {
            int node = queue[++front];
            queue[front] = null;
            return node;
        }

        public boolean isEmpty() {
            return front == rear;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el número de ciudades ");
        int numCiudades = scan.nextInt();
        
        Grafo graph = new Grafo(numCiudades);

        System.out.println("Ingrese el número de reglas ");
        int numReglas = scan.nextInt();

        for(int i = 0; i < numReglas; i++) {
         System.out.println("Ingrese las reglas");
         int n1 = scan.nextInt();
         // int n2 = scan.nextInt();
         
         int n2 = scan.nextInt();
         graph.addEdge(n1, n2);

        }

        graph.traverseGraph();
    }
}
