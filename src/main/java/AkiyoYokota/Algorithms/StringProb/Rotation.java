package AkiyoYokota.Algorithms.StringProb;

public class Rotation {
	//check if a string is a rotation of another.
	public static boolean isRotation (String og, String rot) {
		for(int i = 0 ; i < rot.length(); i++) {

			String newRot = new StringBuilder().append(
					rot.substring(rot.length()-i, rot.length())
					).append(
							rot.substring(0, rot.length()-i)
							).toString();


			if(og.equals(newRot))
				return true;
		}
		return false;
	}
	
	public static void main(String []args) {
		System.out.println(isRotation("beach",  "achbe"));
	}
}
