package AkiyoYokota.Algorithms.RotateArray;

public class RotateArray {
	/*
	 * Rotate an array of n elements to the right by k steps.
		For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
		How many different ways do you know to solve this problem?
	 * 
	 */
	
	public static void print( Integer[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("]");
	}
	
	//space: O(n)
	//time: O(n)
	public static Integer[] rotateArrayV1 (Integer[] arr, int n, int k) {
		Integer[] newArr = new Integer[n] ;
		
		System.arraycopy(arr, n-k, newArr, 0, k);
		System.arraycopy(arr, 0, newArr, k, n-k);
		
		return newArr;
	}
	
	//space: O(n)
	//time: O(n)
	public static Integer[] rotateArrayV2 (Integer[] arr, int n, int k) {
		Integer[] newArr = new Integer[n] ;
		int j = 0;
		for(int i = n-k ; i < n; i ++, j++) {
			newArr[j] = arr[i];
		}
		for(int i = 0; i < n-k; i++, j++) {
			newArr[j] = arr[i];
		}
		
		return newArr;
	}
	
	//Bubble Rotate
	//O(1) space
	//O(n*k) time
	public static void rotateArrayV3 (Integer[] arr, int order) {
		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				print(arr);
			}
			//print(arr);
		}
	}
	
	//Reversal
	//space: O(1)
	//time: O(n) 
	public static void rotateArrayV4 (Integer[] arr, int order) {
		if (arr == null || arr.length==0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		if(order > arr.length){
			order = order %arr.length;
		}
	 
		//length of first part
		int a = arr.length - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
	 
	}
	
	public static void reverse(Integer[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
			print(arr);
		}	
	}
	
	public static void main (String [] args) {
		Integer[] arr = new Integer[] {1,2,3,4,5,6,7};
		//print(rotateArrayV1(arr, 7, 3));
		//print(rotateArrayV2(arr, 7, 3));
		
//		rotateArrayV3(arr, 3);
//		print(arr);

		rotateArrayV4(arr, 3);
		print(arr);
	}
}
