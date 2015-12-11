/**
 * 
 * @author Cecilia Torres, Yessica Alvarez
 *         Ejemplo del recorrido en Primero en Amplitud
 *
 */

import java.util.Scanner;
import java.util.Arrays;

public class BusquedaAmplitud {
    // private int[][] matrizBinaria;
    private int numNodos; // Numero de "ciudades" del grafo
    private int size = 9;
    private char meta = 'h';
    private char[][] reglas = {  {'a','#'}, 
                                 {'a','b'},
                                 {'a','d'},
                                 {'a','e'}, 
                                 {'b','c'}, 
                                 {'c','f'}, 
                                 {'c','g'}, 
                                 {'f','h'}, 
                                 {'e','i'}
                            };

    private char[][] abiertas = new char[20][2];
    private char[][] cerradas = new char[20][2];

    public void recorrerReglas() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print(reglas[i][j]);
            }
            System.out.println("");
        }
        
        // reglas = { {1,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{4,9}};
    }

    public void abiertas() {
        abiertas[0][0] = 'a';
        abiertas[0][1] = '#';
        // String s = new String;
        
        // int edoInicial = abiertas[0][0];
        char edoActual = abiertas[0][0];
        int renglon = 0;

        for(int k = 0; k < size; k ++) {
            
            edoActual = abiertas[renglon][0];
            System.out.println("Edoactual "+edoActual);
            
            if(edoActual != meta) {      // Si no es la meta
                for(int i = 1; i < size; i++) {
                    if(edoActual == reglas[i][0] )  // Si es edoActual deriva reglas, las añadimos a abiertas
                    {
                        abiertas[i][1] = edoActual;        // 1 Origen
                        abiertas[i][0] = reglas[i][1];      // 0  Derivada
                    }

                    cerradas[i][0] = abiertas[i][0];
                    cerradas[i][1] = abiertas[i][1];

                    // System.out.println("Abiertas " + abiertas[i][0]+abiertas[i][1]);
                }

                // for(int j = 1; j < size; j++) {
                //     if(edoActual == reglas[j][0]) {
                //         borrarEnAbiertas(j); 
                //     }
                // }
                // abiertas[k][0] = 0;
                // abiertas[k][1] = 0;
                renglon = renglon + 1;

            }
            else break;
        }
        System.out.println("Abiertas");
        for(int j = 0; j < size; j++) {
            // for(int j = 0; j < 2; j++) {
            System.out.print(abiertas[j][0]);
            System.out.print(abiertas[j][1]);
            // }
            System.out.println("");
        }

        System.out.println("Cerradas");
        for(int j = 0; j < size; j++) {
            // for(int j = 0; j < 2; j++) {
            System.out.print(cerradas[j][0]);
            System.out.print(cerradas[j][1]);
            // }
            System.out.println("");
        }
    }

    public void borrarEnAbiertas(int i) {
        abiertas[i][0] = 0;
        abiertas[i][1] = 0;

    }

    public char estadoActual(int i) {
        for(int j = 0; j < size; j++) {
            if(abiertas[j][0] != abiertas[i][0]) {
                return abiertas[j][0];
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // System.out.println("Ingrese el número de ciudades ");
        // int numCiudades = scan.nextInt();

        BusquedaAmplitud bfs = new BusquedaAmplitud();

        // System.out.println("Ingrese el número de reglas ");
        // int numReglas = scan.nextInt();

        // for(int i = 0; i < numReglas; i++) {
        //     System.out.println("Ingrese las reglas");
        //     int n1 = scan.nextInt();

        //     int n2 = scan.nextInt();
        //     bfs.llenarReglas(n1,n2,i);
        // }

        bfs.recorrerReglas();
        bfs.abiertas();
    }
}
