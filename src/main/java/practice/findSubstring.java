package practice;

import java.util.*;

/**
 * Created by ayokota on 9/7/20.
 */
public class findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if(s.isEmpty())
            return result;

        Map<String, Integer> wordCounter = new HashMap<>();
        for(String word : words) {
            int counter = wordCounter.getOrDefault(word, 0) + 1;
            wordCounter.put(word, counter);
        }
        int numWords = words.length;
        int len = words[0].length();
        int totalLen = len * numWords;


        for(int i = 0; i <= s.length() - totalLen; i++) {

            Map<String, Integer> seen = new HashMap<>();

            boolean found = true;
            for(int j = 0; j < totalLen; j += len) {

                String substr = s.substring(i + j, i + j + len);
                System.out.println(substr);
                if(!wordCounter.containsKey(substr)) {
                    found = false;
                    break;
                }

                int counter = seen.getOrDefault(substr, 0) + 1;
                if(counter > wordCounter.get(substr)) {
                    found = false;
                    break;
                }

                seen.put(substr, counter);
            }

            if(found == true) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findSubstring solution = new findSubstring();

        System.out.println(solution.findSubstring("goodgoodgoodbestword", new String[] {"word","good","best","good"}));
    }

}
