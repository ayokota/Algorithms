package AkiyoYokota.Algorithms.HoppableTower;

public class HoppableTower {
	
	
	
	public static boolean isHoppable (int[] towers, int position ) {
		if(position < 0)
			return false;
		if(towers[position] >= (towers.length-position))
			return true;
		
		if(towers[position]>0) {
			for(int i = towers[position]; i >0; i--) {
				if(isHoppable (towers, position +i))
					return true;
			}
		} 
		return false;
	}
	
	public static void main (String [] args) {
		int[] towers = {4, 2, 0, 0, 1, 1};
		System.out.println(isHoppable(towers, 0));
	}
}
