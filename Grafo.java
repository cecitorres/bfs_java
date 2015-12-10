/**
 * 
 * @author Cecilia Torres, Yessica Alvarez
 *         Ejemplo del recorrido en Primero en Amplitud
 *
 */
import java.util.Scanner;
public class Grafo {
    private int[][] matrizBinaria;
    private int size; // Numero de "ciudades" del grafo
    private Estados[] estados;
    private Queue queue;
    public Grafo(int size) {
        this.size = size;
        matrizBinaria = new int[size][size];// Inicializa con todos en 0
        estados = new Estados[size];
        for (int i = 0; i < size; i++) {
            estados[i] = Estados.NUEVO;
        }
        queue = new Queue(size);
    }

    // Añade las relaciones a la matriz (0 y 1)
    public void addEdge(int nodoOrigen, int nodoDestino) {
        int indiceOrigen = nodoOrigen - 1;
        int indiceDestino = nodoDestino - 1;
        
        matrizBinaria[indiceOrigen][indiceDestino] = 1;
        matrizBinaria[indiceDestino][indiceOrigen] = 1;
    }

    public void recorrerGrafo() {
        System.out.println("Usando algoritmo BFS para recorrer el grafo");

        for (int i = 0; i < size; i++) {
            if (estados[i] != Estados.VISITADO) {
                bfs(i+1);
            }
        }
    }

    private void bfs(int currentNodeName) {
        queue.add(currentNodeName);
        estados[currentNodeName-1] = Estados.EN_COLA;
        while(!queue.isEmpty()){
            int visitedNodeName = queue.remove();
            estados[visitedNodeName-1] = Estados.VISITADO;
            System.out.println(visitedNodeName);
            for(int i = 0; i < size; i++){
                if(matrizBinaria[visitedNodeName-1][i] != 0){
                    if(estados[i] == Estados.NUEVO){
                        queue.add((i+1));
                        estados[i] = Estados.EN_COLA;
                    }
                }
            }
        }
    }

    public enum Estados {
        NUEVO, EN_COLA, VISITADO
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

        graph.recorrerGrafo();
    }
}
