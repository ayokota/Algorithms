package AkiyoYokota.Algorithms.Atoi;

public class Atoi {
	//string to int
	public static Integer atoi (String input) {
		int response = 0;
		
		for(int i = 0 ; i < input.length(); i++) {
			char c = input.charAt(i);
			
			int ASCII = c - 48;
			if(ASCII >=0 && ASCII < 10) {
				response *= 10;
				response += ASCII;
				//System.out.println(ASCII + " " + c);
			} else {
				return null;
			}
		}
		
		return response;
	}
	
	public static void main (String [] args ) {
		System.out.println(atoi("rhwjekh0023hihwejrh"));
	}
}
