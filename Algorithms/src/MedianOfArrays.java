import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfArrays {
	 public static double findMedianSortedArrays(int A[], int B[]) {
		 	if(A == null || (A.length == 0 && B.length ==1)){
		 		return B[0];
		 	}
		 	if(B == null || (B.length == 0 && A.length == 1)){
		 		return A[0];
		 	}
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        for(int i = 0; i < A.length; i++){
	        	result.add(A[i]);
	        }
	        for(int j = 0; j < B.length; j++){
	        	result.add(B[j]);
	        }
	        
	        Collections.sort(result);

	        int length = result.size();
	        if(length == 1){
	            return (double)result.get(0);
	        }else{
	 		    return ((length%2 == 1)?result.get(length/2):(result.get(length/2) + result.get(length/2 - 1))/2.0);
	        }
	 }
	 
	 public static void main(String[] args){
		 int[] A = {1,2};
		 int[] B = {1,2};
		 System.out.println(MedianOfArrays.findMedianSortedArrays(A, B));
	 }
}
