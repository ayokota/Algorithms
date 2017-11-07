package AkiyoYokota.Algorithms.MergeInterval;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeInverval {
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals== null )
			return intervals;
		
		if(intervals.size()==1) {
			
		}
		
		List<Interval> result = new LinkedList<Interval> ();
		
		for(Interval interval : intervals ) {
			if(interval.getEnd() < newInterval.getStart()) {
				result.add(interval);
			} else if(interval.getStart() > newInterval.getEnd()) {
				result.add(newInterval);
				newInterval = interval;
			} else if (interval.getEnd()>= newInterval.getStart() || interval.getStart() <= newInterval.getEnd()){
				newInterval = new Interval (Math.min(interval.getStart(), newInterval.getStart()), Math.max(newInterval.getEnd(), interval.getEnd()));
			}
		}
		result.add(newInterval);
		
		return result;
	}

	
	public static List<Interval> merge (List<Interval> intervals) {
		if(intervals== null || intervals.size()<2)
			return intervals;
		
		
		List<Interval> result = new LinkedList<Interval> ();
		Collections.sort(intervals, new IntervalComparator());
		
		Interval current = intervals.get(0);
		for(Integer i = 1; i < intervals.size(); i++) {
			if(current.getEnd() > intervals.get(i).getStart() ) {
				current.setEnd(Math.max(current.getEnd(), intervals.get(i).getEnd()));
			}else {
				result.add(current);
				current = intervals.get(i);
			}
		}
		result.add(current);

	return result;
}
	
	public static void main (String [] args) {
		
		MergeInverval MI = new MergeInverval();
		
		List<Interval> intervals = new LinkedList<Interval> ();
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(15,18));
		intervals.add(new Interval(8,10));
		System.out.println("before: " + intervals);
		
		System.out.println("after: " + merge(intervals));
		
		
		List<Interval> intervals2 = new LinkedList<Interval> ();
		intervals2.add(new Interval(3,6));
		intervals2.add(new Interval(1,5));
		intervals2.add(new Interval(10,12));
		intervals2.add(new Interval(9,15));
		intervals2.add(new Interval(11,13));
		intervals2.add(new Interval(17,19));
		intervals2.add(new Interval(18,26));
		intervals2.add(new Interval(18,26));
		intervals2.add(new Interval(5,6));
		intervals2.add(new Interval(1,2));
		intervals2.add(new Interval(7,9));
		intervals2.add(new Interval(2,5));

		System.out.println("before: " + intervals2);
		
		System.out.println("after: " + merge(intervals2));
		
		System.out.println("insert: " + insert(merge(intervals2), new Interval(14, 18)));

	}
	

}

