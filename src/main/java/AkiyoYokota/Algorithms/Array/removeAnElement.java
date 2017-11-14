package AkiyoYokota.Algorithms.Array;

public class removeAnElement {
	public static void print( int[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("]");
	}
	
	public static int[] remove(int[] intArray, int c)
	{
	    for (int i = 0; i < intArray.length; i++)
	    {
	        if (intArray[i] == c)
	        {
	            int[] copy = new int[intArray.length-1];
	            System.arraycopy(intArray, 0, copy, 0, i);
	            System.arraycopy(intArray, i+1, copy, i, intArray.length-i-1);
	            return copy;
	        }
	    }
	    return intArray;
	}
	
	public static void main(String[] args) {
		int[] intArray = {1, 2, 3, 5};
		print(remove(intArray,2));
	}
}
