package TheReturn;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayokota on 11/19/20.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[] temp = new int[prices.length];
        temp[0] = 0;

        //apply a first transaction
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            //temp[i] - maximum profit for a period [0, i]
            temp[i] = Math.max(temp[i - 1], prices[i] - min);
        }

        //apply a second transaction
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i > 0; i--) {
            max = Math.max(max, prices[i]);
            //skip 2nd transaction or apply 2nd transaction to [i, prices.length - 1] period
            temp[i] = Math.max(temp[i], temp[i - 1] + (max - prices[i]));
        }

        int result = 0;
        for (int n : temp) {
            result = Math.max(result, n);
        }

        return result;
    }

    public static void main(String[] args) {
        new MaxProfit().maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        Set<Integer> num2Set = new HashSet<>();
        for(int num : nums2) {
            num2Set.add(num);
        }

        Set<Integer> intersection = new HashSet<>();
        for(int num : nums1) {
            if(num2Set.contains(num))
                intersection.add(num);
        }

        int[] result = new int[intersection.size()];
        int i = 0;
        for(int num : intersection) {
            result[i++] = num;
        }

        return result;
    }

}
