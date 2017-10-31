package AkiyoYokota.Algorithms.KthLargestElement;

public class KthLargestElement {
	//method 1: use merge sort and get kth element.
	
	public static int findKthsmallest (Integer[] arr, int k) {
		if(arr==null && k < 1)
			return 0;
		
		return findK(k, arr, 0, arr.length -1 );
	}
	
	
	public static void print( Integer[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("]");
	}
	
	
	
	public static int findK (int k, Integer[] arr, int start, int end) {
		int pivot = arr[end];
		
		int left = start;
		int right = end;
		
		
		while (true) {
			while(arr[left] < pivot && left < right) {
				left ++;
			} 
			while(arr[right] >= pivot && right > left) {
				right --;
			}
			if(left == right ) {
				break;
			}
			swap(arr, left, right);
			print(arr);
		}
		
		swap (arr, left, end);
		print(arr);
		if(k == (left+1) ) {
			return pivot;
		} else if( k < left + 1) {
			return findK (k, arr, start, left -1);
		} else {
			return findK (k, arr, left + 1, end);
		}
	}
	
	public static void swap (Integer[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void main (String [] args) {
		Integer [] arr = new Integer[] { 3, 5, 7, 6, 1, 2, 9, 4};
		System.out.println(findKthsmallest(arr, 3));
		
	}
}
