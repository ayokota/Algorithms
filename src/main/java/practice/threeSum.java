package practice;

import com.google.gson.Gson;

import java.util.*;

/**
 * Created by ayokota on 8/22/20.
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();

        Integer lastNum = null;
        for(int i = 0; i < nums.length; i++) {
            // already processed this num.
            if(lastNum != null && lastNum == nums[i])
                continue;
            int complement = 0 - nums[i];

            Map<Integer, Integer> complements = twoSum(nums, i + 1, complement);
            for(int a : complements.keySet()) {
                List<Integer> partial = new LinkedList<>();
                partial.add(a);
                partial.add(complements.get(a));
                partial.add(nums[i]);
                result.add(partial);
            }

            lastNum = nums[i];
        }

        return result;
    }

    public Map<Integer, Integer> twoSum(int[] nums, int i, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> complementSet = new HashSet<>();

        for(; i < nums.length; i++) {
            int complement = target - nums[i];

            if(complementSet.contains(complement)) {
                int smaller = Math.min(complement, nums[i]);
                int bigger = Math.max(complement, nums[i]);
                result.put(smaller, bigger);
            } else {
                complementSet.add(nums[i]);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        threeSum ts = new threeSum();

        System.out.println(
                new Gson().toJson(
                    ts.threeSum(new int[]{-1,0,1,2,-1,-4})
                )
        );
    }
}
