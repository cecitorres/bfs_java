import java.util.Scanner;
import java.util.Arrays;


public class TestProg
{

   public static void main(String[] args)
   {
		Scanner scan = new Scanner(System.in);
		//                        0  1  2  3  4  5  6  7  8
		// ===================================================
		int[][] conn = {  
						{ 0, 1, 1, 1, 1, 0, 0, 0, 0 },  // 0
						{ 1, 0, 0, 0, 0, 1, 0, 0, 0 },  // 1
						{ 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 2
						{ 1, 0, 0, 0, 0, 0, 0, 0, 1 },  // 3
						{ 1, 0, 0, 0, 0, 0, 0, 0, 0 },  // 4
						{ 0, 1, 0, 0, 0, 0, 1, 0, 0 },  // 5
						{ 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
						{ 0, 0, 1, 0, 0, 0, 0, 0, 0 },  // 7
						{ 0, 0, 0, 3, 0, 0, 0, 0, 0 } };// 8

		int[][] reglas;

		System.out.println("Ingrese el número de ciudades ");
		int numCiudades = scan.nextInt();
		
		System.out.println("Ingrese el número de reglas ");
		int numReglas = scan.nextInt();
		reglas = new int[numReglas][2];

		for(int i = 0; i < numReglas; i++) {
			System.out.println("Ingrese las reglas");
			int n1 = scan.nextInt();
			// int n2 = scan.nextInt();
			reglas[i][0] = n1;
			n1 = scan.nextInt();
			reglas[i][1] = n1;
		}

		int [][]matriz = new int[numCiudades][numCiudades];

		
		// Llenamos array de ciudades
		for(int i = 0; i < numReglas; i++) {
				int origen = reglas[i][0] - 1;
				int destino = reglas[i][1] - 1;

				matriz[origen][destino] = 1;
				matriz[destino][origen] = 1;
		}

		for(int j = 0; j < numCiudades; j++) {
			for(int k = 0; k < numCiudades; k++) {
				System.out.print(matriz[j][k]);
			}
			System.out.println("");
		}


		Graph G = new Graph(matriz);
		G.BFS();

   }
}
