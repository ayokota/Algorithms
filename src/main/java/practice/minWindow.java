package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayokota on 8/24/20.
 */
public class minWindow {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";

        //build tcount & sSet
        Map<Character, Integer> tCount = new HashMap<>();
        Set<Character> tSet = new HashSet<>();
        for(char c : t.toCharArray()) {
            tSet.add(c);
            int count = tCount.getOrDefault(c, 0) + 1;
            tCount.put(c, count);
        }

        //build sCount
        Map<Character, Integer> sCount = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = s.charAt(i);

            if(tSet.contains(c)) {
                int count = sCount.getOrDefault(c, 0) + 1;
                sCount.put(c, count);
            }
        }

        int formed = 0;
        //check #formed
        for(char c : tCount.keySet()) {
            if(sCount.containsKey(c) && sCount.get(c) >= tCount.get(c))
                formed++;
        }

        if(formed == tCount.keySet().size()) {
            return s.substring(0, t.length());
        }

        int[] result = new int[]{0, Integer.MAX_VALUE};
        int[] slidingWindow = new int[]{formed, 0, t.length() - 1};
        while(slidingWindow[2] < s.length()) {
            slideRight(slidingWindow, tSet, sCount, tCount, s);
            if(slidingWindow[2] == s.length())
                break;
            slideLeft(slidingWindow, tSet, sCount, tCount, s);

            //compare and set smaller window
            if(slidingWindow[2] - slidingWindow[1] < result[1] - result[0]) {
                result[1] = slidingWindow[2];
                result[0] = slidingWindow[1];
            }

            //now we should move left enough to break form;
            slidingWindow[1]++;
            if(slidingWindow[1] >= slidingWindow[2])
                break;
        }

        if(result[1] == Integer.MAX_VALUE)
            return "";
        return s.substring(result[0], result[1] + 1);
    }

    public void slideRight(int[] slidingWindow, Set<Character> tSet, Map<Character, Integer> sCount,
                           Map<Character, Integer> tCount, String s) {
        //move j to right until we form
        while(slidingWindow[0] < tCount.keySet().size() && slidingWindow[2] < s.length()) {
            slidingWindow[2]++;

            if(slidingWindow[2] == s.length())
                break;

            char c = s.charAt(slidingWindow[2]);

            if(tSet.contains(c)) {

                int count = sCount.getOrDefault(c, 0) + 1;
                sCount.put(c, count);

                // check to see if this increment trigger a matching count
                if(count == tCount.get(c))
                    slidingWindow[0]++;
            }

        }
    }

    public void slideLeft(int[] slidingWindow, Set<Character> tSet, Map<Character, Integer> sCount,
                          Map<Character, Integer> tCount, String s) {
        //move i to right right before we unform
        while(slidingWindow[1] < slidingWindow[2]) {
            //check next char
            char c = s.charAt(slidingWindow[1]);

            if(tSet.contains(c)) {
                int count = sCount.get(c) - 1;

                sCount.put(c, count);
                //if count went below, stop here
                if(count < tCount.get(c)) {
                    slidingWindow[0]--;
                    break;
                }
            }

            slidingWindow[1]++;
        }

    }

    public static void main(String[] args) {
        minWindow mw = new minWindow();
        System.out.println(mw.minWindow("abc", "cba"));
    }
}
