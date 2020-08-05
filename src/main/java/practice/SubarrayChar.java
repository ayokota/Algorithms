package practice;

/**
 * Created by ayokota on 8/4/20.
 */
public class SubarrayChar {

    public static int subarraysWithKDistinct(String s, int K) {
        return getSubArraySuperSet(s, K) - getSubArraySuperSet(s, K - 1);
    }

    public static int getSubArraySuperSet(String s, int K) {
        int result = 0;
        int right = 0;
        int left = 0;
        int kCounter = 0;
        char[] counter = new char[26];

        while(right < s.length()) {
            if(counter[s.charAt(right) - 'a'] == 0)
                kCounter++;

            // taking care of kCounter > K, need to move left ptr to right until kCounter == K
            while(kCounter > K) {
                counter[s.charAt(left) - 'a']--;

                if(counter[s.charAt(left) - 'a'] == 0)
                    kCounter--;
                left++;
            }

            counter[s.charAt(right) - 'a']++;
            result += (right - left + 1);
            right++;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(subarraysWithKDistinct("pqpqs", 2));
        System.out.println(subarraysWithKDistinct("aabab", 3));

    }
}
