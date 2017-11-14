package AkiyoYokota.Algorithms.RegExMatching;

public class RegExMatching {
	/*
	 * Implement regular expression matching with support for '.' and '*'.

		'.' Matches any single character.
		'*' Matches zero or more of the preceding element.
		
		The matching should cover the entire input string (not partial).
		
		The function prototype should be:
		bool isMatch(const char *s, const char *p)
		
		Some examples:
		isMatch("aa","a") return false
		isMatch("aa","aa") return true
		isMatch("aaa","aa") return false
		isMatch("aa", "a*") return true
		isMatch("aa", ".*") return true
		isMatch("ab", ".*") return true
		isMatch("aab", "c*a*b") return true
	 */

	
	
	public static boolean isMatch (String s, String p) {
		if(p.length()==0) {
			return s.length()==0;
		}
		if(s.length()==0)
			return false;
		
		int i=0 , j = 0;
		//iterate regex from position 0 to end
		for( ; j < p.length(); j++) {
			char c = p.charAt(j);
			//if '.' move str to next 
			if(c== '.') {
				//if next char is *, move str until ??
				
				if(p.length() > j+1 && p.charAt(j+1)=='*') {
					int k = i;
					while(k < s.length() ) {
						if(isMatch(s.substring(k+1), p.substring(j)))
								return true;
						k++;
					}
					
				} else {
					i++;
				}
			}
			//else if match move next
			else if (c==s.charAt(i)) {
				//i++;
				//if next char is not *, move str until unmatch
				if(p.length() > j+1 && p.charAt(j+1)=='*') {
					j++;
					while(s.length()> i && c==s.charAt(i)) {
						i++;
					}
				} else {
					i++;
				}
			}
			//else return false
			else {
				return false;
			}
		}
		if(i == (s.length())) 
			return true;
		return false;
	}
	
//	public static boolean isMatch (String s, String p) {
//		// base case
//		if (p.length() == 0) {
//			return s.length() == 0;
//		}
//	 
//		// special case
//		if (p.length() == 1) {
//	 
//			// if the length of s is 0, return false
//			if (s.length() < 1) {
//				return false;
//			}
//	 
//			//if the first does not match, return false
//			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
//				return false;
//			}
//	 
//			// otherwise, compare the rest of the string of s and p.
//			else {
//				return isMatch(s.substring(1), p.substring(1));
//			}
//		}
//	 
//		// case 1: when the second char of p is not '*'
//		if (p.charAt(1) != '*') {
//			if (s.length() < 1) {
//				return false;
//			}
//			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
//				return false;
//			} else {
//				return isMatch(s.substring(1), p.substring(1));
//			}
//		}
//	 
//		// case 2: when the second char of p is '*', complex case.
//		else {
//			//case 2.1: a char & '*' can stand for 0 element
//			if (isMatch(s, p.substring(2))) {
//				return true;
//			}
//	 
//			//case 2.2: a char & '*' can stand for 1 or more preceding element, 
//			//so try every sub string
//			int i = 0;
//			while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
//				if (isMatch(s.substring(i + 1), p.substring(2))) {
//					return true;
//				}
//				i++;
//			}
//			return false;
//		}
//	}
	
	public static void main (String[] args) {
		System.out.println(isMatch("aa","a")); //false
		System.out.println(isMatch("aa","aa")); //true 
		System.out.println(isMatch("aaa","aa")); //false
		System.out.println(isMatch("aa", "a*")); //true
		System.out.println(isMatch("aa", ".*")); //true
		System.out.println(isMatch("ab", ".*")); //true
		System.out.println(isMatch("aab", "c*a*b")); //true
		System.out.println(isMatch("cccccccccaaaaaaaaab", "c*a*b")); //true
		System.out.println(isMatch("cccccccccaaaaaaaaabab", ".*ab")); //true

	}
	
	/*
	 * 			System.out.println(str.charAt(i) + " : " + regEx.charAt(j) + " : " + c);
		
			if(regEx.charAt(j)!='*') {
				c = regEx.charAt(j);
				if(str.charAt(i) != c && c!='.') { 
					if(j+1 < regEx.length() && regEx.charAt(j+1)=='*') {
						j++;
						j++;
					}
					else
						return false;
				}
			} else {
				while(i < str.length() && str.charAt(i)==c  )
					i++;
			}
	 */
}
