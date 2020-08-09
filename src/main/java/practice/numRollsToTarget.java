package practice;

import java.util.Arrays;

/**
 * Created by ayokota on 8/6/20.
 */
public class numRollsToTarget {
    public int numRollsToTarget(int d, int f, int target) {
        Long mod = 000000007L;
        int[][] mem = new int[d + 1][target + 1];
        for(int i = 0; i < mem.length; i++)
            Arrays.fill(mem[i], -1);
        return numRollsToTargetHelper(d, f, target, mem, mod);
    }

    public int numRollsToTargetHelper(int d, int f, int target, int[][] mem, Long mod) {
        if(target < 0)
            return 0;
        if(mem[d][target] != -1)
            return mem[d][target];
        else if(d > target || target > d * f) {
            // too many dices compare to target
            // largest faces cannot come up with target
            mem[d][target] = 0;
            return 0;
        } else if(d == 1) {
            mem[d][target] = 1;
            return 1;
        }

        int sum = 0;
        for(int i = 1; i <= f; i++) {
            sum += numRollsToTargetHelper(d - 1, f, target - i, mem,  mod);
            sum %= mod;
        }


        mem[d][target] = sum;
        return sum;
    }
}
