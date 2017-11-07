package AkiyoYokota.Algorithms.RemoveDup;

import java.util.Arrays;

public class RemoveDupFromSortedArray {
	
	public static void print( int[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("]");
	}
	
	public static int[] removeDup (int[] arr) {
		int[] response = new int[arr.length];
		Arrays.sort(arr);
		int j = 1;
		response[0]=arr[0];
		for(int i = 1; i<arr.length; i++) {
			if(arr[i] != response[j-1]) {
				response[j] = arr[i];
				j++;
			}
		}
		return response;
	}
	
	public static void main(String [] args) {
		
		int [] arr = { 2,5,2,3,5,2,23,4,5,6,2,3,4,4,6,7,423,452,7,2,46,52,213,412,4,151,1,5,1};
		
		print(removeDup(arr));
	}
}
