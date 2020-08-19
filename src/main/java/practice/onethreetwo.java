package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ayokota on 8/17/20.
 */
public class onethreetwo {

    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (top < n && nums[i] > nums[top]) third = nums[top++];
            nums[--top] = nums[i];
        }

        return false;
    }

    public static void main(String[] args) {
        new onethreetwo().find132pattern(new int[]{-2, -2, 2, 1, 2, -2 ,2});

        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
        anagrams.values().stream().collect(Collectors.toList());


    }
}
