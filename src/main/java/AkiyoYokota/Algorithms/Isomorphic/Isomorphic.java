package AkiyoYokota.Algorithms.Isomorphic;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
	/*
	 * Given two strings s and t, 
	 * determine if they are isomorphic. 
	 * Two strings are isomorphic 
	 * if the characters in s can be replaced to get t.
	 */
	
	public static boolean isIsomorphic (String s, String t) {
	    if(s==null||t==null)
	        return false;
		if(s.length()!=t.length())
			return false;
		
		Map<Character, Character> charMapping = new HashMap<Character, Character>();
		for(int i = 0; i < s.length(); i++) {
			if(charMapping.containsKey(s.charAt(i)) 
					&& !charMapping.get(s.charAt(i)).equals(t.charAt(i))) {
				return false;
			} else {
				if(charMapping.containsKey(t.charAt(i)))
					return false;
				charMapping.put(s.charAt(i), t.charAt(i));
			}
		}
		
		return true;
	}
	
	public static void main (String [] args) {
		String egg = "egg";
		String add = "add";
		
		String foo = "foo";
		String bar = "bar";
		
		String paper = "paper";
		String title = "title";
		
		System.out.println("egg & add: " + isIsomorphic(egg,  add));
		System.out.println("foo & bar: " + isIsomorphic(foo,  bar));
		System.out.println("paper & title: " + isIsomorphic(paper,  title));

	}
}
