package AkiyoYokota.Algorithms.ReversePolishNotation;

import java.util.Stack;

public class ReversePolishNotation {
	/*
	 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	
	public static void print( String[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("]");
	}
	
	public static int method1 (String[] arr) {
		
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i].equals("+")) {
				int b = s.pop();
				int a = s.pop();
				s.push(a+b);
			}
			else if(arr[i].equals("*")) {
				int b = s.pop();
				int a = s.pop();
				s.push(a*b);
			}
			else if(arr[i].equals("-")) {
				int b = s.pop();
				int a = s.pop();
				s.push(a-b);
			}
			else if(arr[i].equals("/")) {
				int b = s.pop();
				int a = s.pop();
				s.push(a/b);
			}
			else {
				s.push(Integer.parseInt(arr[i]));
			}
		}
		
		return s.pop();
	}
	
	public static void main(String[] args) {
		String[] arr = new String[] {"2", "1", "+", "3", "*"};
		String[] arr2 = new String[] {"4", "13", "5", "/", "+"};
		
		System.out.println(method1(arr));
		System.out.println(method1(arr2));

	}
}
