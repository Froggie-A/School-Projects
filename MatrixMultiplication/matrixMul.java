/*
 * Implementations for the driver matrix multiplication method
 * @author Amy Tran
*/

import java.util.Scanner;
 
public class matrixMul{
	/*
 	* This driver creates two 2D matrices of randMatrix class from the user input size
	* it then sorts left matrix rows and right matrix columns
	* then it multiplies left matrix with the right matrix and saves it as new 2D matrix
	* prints: random left and right matrices, sorted left and right matrices, new matrix
	*/
	
	public static int[][] matrix;
	public static  int[][] leftMatrix;
	public static  int[][] rightMatrix;
	public boolean isMade = false;
	
	public matrixMul(int n, String side) {
		
		//Spiltting matrices by which side/column it is sorting by using if-else statements
		
			if(side.equals("left")) {
				randMatrix lMatrix = new randMatrix(n,"row");
				System.out.println("Sorted Left Matrix: ");
				printMatrix(getMatrix("row")); 
		
			}
			else if(side.equals("right")) {
				randMatrix rMatrix = new randMatrix(n,"column");
				System.out.println("Sorted Right Matrix: ");
				printMatrix(getMatrix("column")); 
				isMade = true;
			}
		
			
		// If statment to check if both of the matrices is sorted.	
		
		if(isMade == true) {
			int newMatrix[][] = new int[n][n];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                for (int l = 0; l < n; l++)
	                	newMatrix[i][j] += leftMatrix[i][l] * rightMatrix[l][j];
	            }
	        }
	        System.out.println("Multipled Matrix: ");
	        printMatrix(newMatrix);
			}
		}
		
	/*
	 * storeMatrix - takes in a int[][] and a String and stores it for the multiplication process.
	 * int [][] - the matrix that needs to be stored.
	 * String side - designates which matrix (left/right) it is and stores it in the correct variable.
	 */
	
	public static void storeMatrix(int[][] m, String side) {
		if(side.equals("row")) {
			leftMatrix=m;
		}
		if(side.equals("column")) {
			rightMatrix=m;
		}
	}
	
	/*
	 * getMatrix - takes in a String to figure out with matrix to return (left/right).
	 * returns - int[][] : matrix stored in the (left/right matrix)variables
	 */
	
	public int[][] getMatrix(String side) {
		if(side.equals("row")) {
			return leftMatrix;
		}
		if(side.equals("column")) {
			return rightMatrix;
		}
		return null;
	}
	
	/*
	 * printMatrix - takes an int[][] and formats and prints it
	 */
	
	public static void printMatrix(int[][] m) {
		 System.out.println();
	       for(int i=0;i<m.length;i++){
	    	   for(int j=0;j< m[i].length;j++) {
	    		   System.out.printf("%9d",m[i][j]);
	    	   }
	    	   System.out.println("");
	       }
	    System.out.print("\n");
	    }

	
  	public static void main(String[] args){	
  		System.out.println("Please input a size for the matrices: ");
  		
  		boolean isInt = false;
  		/*
  		 // Using args[0]
  		int size = Integer.parseInt(args[0]);
  		//Using Scanner because args[0] doesn't let the user put in an input.
  		
  		System.out.println("Unsorted Left Matrix: ");
      	matrixMul leftMatrix = new matrixMul(size, "left");
      	
      	System.out.println("Unsorted Right Matrix: ");
      	matrixMul rightMatrix = new matrixMul(size, "right");
  	}
  	*/
 
  		Scanner input = new Scanner(System.in);
  		
  		while(isInt == false) {
	  		if(input.hasNextInt()) {
		  		int size = input.nextInt();
		  		
		  		System.out.println("Unsorted Left Matrix: ");
		      	matrixMul leftMatrix = new matrixMul(size, "left");
		      	
		      	System.out.println("Unsorted Right Matrix: ");
		      	matrixMul rightMatrix = new matrixMul(size, "right");
		      	isInt = true;
	  		}
	  		else {
	  			System.out.println("Please put in a valid input.");
	  			input.next();
	  		}
  		}
  		input.close();
  	}

}
