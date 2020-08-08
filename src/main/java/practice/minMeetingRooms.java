package practice;

import java.util.Arrays;

/**
 * Created by ayokota on 8/7/20.
 */
public class minMeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startInd = 0, endInd = 0, rooms = 0;

        while(startInd < n){

            if(start[startInd] < end[endInd])
                rooms++;
            else
                endInd++;
            startInd++;
        }
        return rooms;

    }

    public static void main(String[] args) {
        System.out.println(
                minMeetingRooms(
                        new int[][] {
                                {0,5},
                                {1,4},
                                {3,4},
                                {5,10},
                                {6,10}
                        }
                )
        );
    }
}
