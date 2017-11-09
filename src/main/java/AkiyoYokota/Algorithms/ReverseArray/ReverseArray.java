package AkiyoYokota.Algorithms.ReverseArray;

public class ReverseArray {
	public static void print( int[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("]");
	}
	
	public static int [] reverse (int [] arr) {
		if(arr.length<2)
			return arr;
				
		for(int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		return arr;
	}
	
	public static void main (String [] args) {
		//System.out.println(7/2);
		
		print( reverse(new int[] {1,2,3,4,5,6,7,8 }) ) ;
		print( reverse(new int[] {1,2,3,4,5,6,7 }) ) ;
		print( reverse(new int[] {1,2}) ) ;
		print( reverse(new int[] {1}) ) ;
		print( reverse(new int[] {0}) ) ;

	}
}
