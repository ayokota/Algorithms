package practice;

/**
 * Created by ayokota on 8/6/20.
 */
public class numRollsToTarget {
    static long mod = (long) 1e9 + 7;

    public static int numRollsToTarget(int d, int f, int target) {
        int MOD = (int) Math.pow(10,9) + 7;
        // int[][] dp = new int[d+1][target+1];
        // dp[0][0] = 1;
        int[] dp = new int[target+1];
        dp[0]=1;
        for (int i = 1; i <= d; i++) {
            int[] currRow = new int[target+1]; // dont forget to init a temp array
            for (int j = 1; j <= target && j <= i*f; j++) {
                // j <= i*f ???
                // if 2 dices total and 6 faces, but only on the first dice (i=1), max value = 6, but target is 10
                for (int k = 1; k <= f && k <= j; k++) {
                    currRow[j] = (currRow[j] + dp[j-k]) % MOD;
                    // dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % MOD;
                }
            }
            dp = currRow; // dont forget to update the original array
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
    }
}
