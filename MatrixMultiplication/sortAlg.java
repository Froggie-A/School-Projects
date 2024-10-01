/*
 * Implementations for a Class that performs a Merge sort on an arrays
 * @author Amy Tran
*/

import java.util.Arrays;

public class sortAlg{

  	public static void sortA(int[] arr,int n){
      	// Using Merge Sort for it's nlogn Complexity. This is to account for
  		// Large and Small matrixes, because the complexity will always be nlogn.
  		// Another method I consider was QuickSort, but because of it's worse case , n^2,
  		// I chose not to use it.		
  		
  		if(n > 1) {
	  		
  			int[] S1 = Arrays.copyOfRange(arr,0,(n/2));
	  		int[] S2 = Arrays.copyOfRange(arr,(n/2),n);
	  		
	  		sortA(S1,n/2);
	  		sortA(S2,n-(n/2));

	  		// For Loop makes sure that the array is null, before added back the sorted values.
	  			
  			for(int i = 0; i<arr.length;i++) {
  				arr[i]=-1;
  			}
  			
	  		merge(S1,S2,arr, n);
  		}
  	 }

	private static void merge(int[] S1, int[] S2, int[] arr,int n){
      	int i = 0;
      	int j = 0;
      	int k = 0;
      	
      	
		while(i<S1.length && j< S2.length) {
			if(S1[i] <= S2[j]) {
				arr[k] = S1[i];
				i++;
			}
			else {
				arr[k] = S2[j];
				j++;
			}
			k++;
		}
		while(i<S1.length) {
			arr[k] = S1[i];
			k++;
			i++;
		}
		
		while(j<S2.length) {
			arr[k] = S2[j];
			k++;
			j++;
		}
  	 }
}
