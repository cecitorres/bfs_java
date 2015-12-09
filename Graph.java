import java.util.*;

public class Graph
{
   /* ------------------------------------------
      Data structure used to represent a graph
      ------------------------------------------ */
   int[][]  adjMatrix;
   int      rootNode = 0;
   int      NNodes;

   boolean[] visited; 

   /* -------------------------------
      Construct a graph of N nodes
      ------------------------------- */
   Graph(int[][] mat)
   {
      int i, j;

      NNodes = mat.length;

      adjMatrix = new int[NNodes][NNodes];
      visited = new boolean[NNodes];


      for ( i=0; i < NNodes; i++)
         for ( j=0; j < NNodes; j++)
            adjMatrix[i][j] = mat[i][j];
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
         int nextNode;                // Next node to visit
         int i;

         nextNode = q.remove();

         if ( ! visited[nextNode] )
         {
            visited[nextNode] = true;    // Mark node as visited
            System.out.println("nextNode = " + nextNode );

            for ( i = 0; i < NNodes; i++ )
//          for ( i = NNodes-1; i >=0 ; i-- )
               if ( adjMatrix[nextNode][i] > 0 && ! visited[i] )
                  q.add(i);
         }
      }
   }


   int getUnvisitedChildNode(int n)
   {
      int j;

      for ( j = 0; j < NNodes; j++ )
      {
	 if ( adjMatrix[n][j] > 0 )
         {
	    if ( ! visited[j] )
               return(j);
         }
      }

      return(-1);
   }

   void clearVisited()
   {
      int i;

      for (i = 0; i < visited.length; i++)
         visited[i] = false;
   }

   void printNode(int n)
   {
      System.out.println(n);
   }
}


