/*
 * Implementations for a Class that creates a 2D matrix of random numbers and performs sorting operations
 * @author Amy Tran
*/

import java.util.Arrays;
import java.util.Random;

public class randMatrix{
	
	public int[][] matrix ;
	boolean sorted;
	Random rand = new Random();
   
	/*
	 * randMatrix - constructor for randMatrix that takes in the user input for size n. Makes the matrix and fills it with random elements
	 * 				also prints and stores the matrix for later use.
	 */
	
	public randMatrix(int n,String side){
       matrix = new int[n][n];
       
       for(int i=0; i<n;i++  ) {
    	   for(int j=0; j<n; j++) {
    		   matrix[i][j] = rand.nextInt(100);
    	   }
       }
      matrixMul.printMatrix(matrix);
      matrixMul.storeMatrix(sortMat(side,matrix),side);

	}
	
	/*
	 * sortMat - takes in a String and int[][] and stores it based on the side/axisType (row/column).
	 * String axisType - designates what the matrix needs to be sorted by (row/column).
	 * int[][] - the matrix that needs to be sorted.
	 * returns the sorted matrix.
	 */
	
    public static int[][] sortMat(String axisType,int[][] m ){
    	int[] arr = new int[m.length];
       	if(axisType.equals("row")) {
       		for(int i = 0;i<m.length;i++) {
       			sortAlg.sortA(m[i],m[i].length);
       		}
       	}
       	
       	if(axisType.equals("column")) {
	       for(int j =0;j<m.length;j++) {
	       	for(int i = 0;i<m.length;i++) {
	       			int element= m[i][j];
	       			arr[i]= element;
	       		}
    	sortAlg.sortA(arr,m.length);
	       
	       	for(int i = 0;i<m.length;i++) {
	       			int element= arr[i];
	       			m[i][j] = element;
	       		}
	       }
    }
		return m;
       	
    }
}


