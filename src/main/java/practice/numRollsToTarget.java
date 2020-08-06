package practice;

import java.util.Arrays;

/**
 * Created by ayokota on 8/6/20.
 */
public class numRollsToTarget {
    public static int numRollsToTarget(int d, int f, int target) {
        int[] dices = new int[d];
        Arrays.fill(dices, 1);

        //while largest digit doesn't equal to f
        int result = 0;
        int sum = d;

        while(sum <= d * f) {

            dices[0]++;

            if(increment(dices, f)) {
                sum = sum - (f - 2);
            } else {
                sum++;
            }
            System.out.println(sum);

            if(sum == target)
                result++;
        }


        return result;
    }


    public static boolean increment(int[] nums, int ceiling) {
        int carryOn = nums[0] == ceiling ? 1 : 0;
        if(carryOn == 0)
            return false;

        nums[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            if(carryOn == 1) {
                nums[i]++;
            } else {
                break;
            }

            if(nums[i] == ceiling) {
                nums[i] = 1;
                carryOn = 1;
            } else {
                carryOn = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
    }
}
