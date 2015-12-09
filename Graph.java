import java.util.*;
import java.util.Arrays;

public class Graph
{
   /* ------------------------------------------
      Data structure used to represent a graph
      ------------------------------------------ */
   int[][]  copiaMatriz;
   int      rootNode = 0;
   int      num_Nodos;

   boolean[] nodos_visitados; 

   /* -------------------------------
      Construct a graph of N nodes
      ------------------------------- */
   Graph(int[][] matriz)
   {
      int i, j;

      num_Nodos = matriz.length;

      copiaMatriz = new int[num_Nodos][num_Nodos];
      nodos_visitados = new boolean[num_Nodos];


      for ( i=0; i < num_Nodos; i++)
         for ( j=0; j < num_Nodos; j++)
            copiaMatriz[i][j] = matriz[i][j];
   }


   public void BFS()
   {
      // BFS uses Queue data structure

      Queue<Integer> q = new LinkedList<Integer>();

      clearVisited();
      q.add(0);            // Start the "to visit" at node 0

      /* ===========================================
         Loop as long as there are "active" node
         =========================================== */
      while( !q.isEmpty() )
      {
         int siguienteNodo;                // Next node to visit
         int i;

         siguienteNodo = q.remove();
         if ( ! nodos_visitados[siguienteNodo] )
         {
            nodos_visitados[siguienteNodo] = true;    // Marca al nodo como visitado
            System.out.println("Siguiente Nodo = " + siguienteNodo );

            for ( i = 0; i < num_Nodos; i++ )
//          for ( i = num_Nodos-1; i >=0 ; i-- )
               if ( copiaMatriz[siguienteNodo][i] > 0 && ! nodos_visitados[i] )
                  q.add(i);
         }
      }
   }


   int getUnvisitedChildNode(int n)
   {
      int j;

      for ( j = 0; j < num_Nodos; j++ )
      {
	 if ( copiaMatriz[n][j] > 0 )
         {
	    if ( ! nodos_visitados[j] )
               return(j);
         }
      }

      return(-1);
   }

   void clearVisited()
   {
      int i;

      for (i = 0; i < nodos_visitados.length; i++)
         nodos_visitados[i] = false;
   }

   void printNode(int n)
   {
      System.out.println(n);
   }
}


