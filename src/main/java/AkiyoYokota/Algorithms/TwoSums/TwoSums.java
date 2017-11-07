package AkiyoYokota.Algorithms.TwoSums;

import java.util.LinkedList;
import java.util.List;

public class TwoSums {

	public static Pair twoSums(int [] input, int sum) {
		Pair pair = null;
		
		List<Integer> list = new LinkedList<Integer>();
		for(int i : input) {
			int diff = sum - i;
			if(list.contains(diff)) {
				pair = new Pair(Math.min(i, diff), Math.max(i, diff));
				break;
			} else {
				list.add(i);
			}
		}
		
		return pair;
	}
	
	public static void main(String[] args) {
		int [] input = {2, 7, 11, 15};
		System.out.println(twoSums(input, 18));
	}
}
