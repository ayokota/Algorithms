package AkiyoYokota.Algorithms.MergeInterval;

import java.util.Comparator;

public class IntervalComparator implements Comparator<Interval>{

	public int compare(Interval o1, Interval o2) {
		int start1 = o1.getStart();
		int start2 = o2.getStart();
		return start1 - start2;
	}
}