package AkiyoYokota.Algorithms.StringProb;

public class SubStr {
	public static String subStr(String s, int begin, int end) {
		char [] newStr = new char[end-begin];
		
		int i = 0;
		int j = begin;
		for(; j< end; i++, j++) {
			newStr[i] = s.charAt(j);
		}
		
		s = new String(newStr);
		return s;
	}
	
	public static void main (String [] args) {
		System.out.println(subStr("abcdefg", 2, 5));
	}
}
