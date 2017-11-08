package AkiyoYokota.Algorithms.ValidParentheses;

import java.util.Stack;

public class ValidParentheses {
//	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	
	public static boolean isBalanced ( String input) {
		if(input==null || input.length()==0) {
			return true;
		}
		
		//using stack to push the open parathese
		Stack<Character> openParentheses = new Stack<Character> ();
		for(int i = 0 ; i < input.length(); i ++) {
			char c = input.charAt(i);
			if(c == '(' || c == '[' || c =='{') {
				openParentheses.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				char top = openParentheses.pop();
				if (c==')' && top !='(') {
					return false;
				}
				else if (c==']' && top !='[') {
					return false;
				}
				else if (c=='}' && top !='{')  {
					return false;
				}
			}
		}

		return openParentheses.isEmpty();
	}
	
	public static void main (String [] args) {
		System.out.println(isBalanced("([{}])"));
	}
}
