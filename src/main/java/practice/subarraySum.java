package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayokota on 8/11/20.
 */
public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        // map: s(i)-n(i) -> count
        Set<Integer> mem = new HashSet<Integer>();
        int count = 0;

        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            mem.add(sum);
            sum += nums[i];
            if(mem.contains(sum - k))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        subarraySum s = new subarraySum();

        System.out.println(s.subarraySum(new int[] {1, 2, 4, 8, 9, 13}, 12));

        System.out.println(s.subarraySum(new int[] {1, 2, 5, 3, 8, 9}, 11));

        System.out.println(s.subarraySum(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1}, 4));

        System.out.println(s.subarraySum(new int[] {1, 1, 1, -1, 1}, 3));

    }
}
