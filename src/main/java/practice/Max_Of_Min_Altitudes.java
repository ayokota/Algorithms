package practice;

import com.google.gson.Gson;

/**
 * Created by ayokota on 8/5/20.
 */
public class Max_Of_Min_Altitudes {


    public static int solution(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = Integer.MAX_VALUE;
        grid[n - 1][m - 1] = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) continue;
                int up = i == 0 ? Integer.MIN_VALUE : dp[i - 1][j];
                int left = j == 0 ? Integer.MIN_VALUE : dp[i][j - 1];
                dp[i][j] = Math.min(grid[i][j], Math.max(up, left));
            }
        }
        System.out.println(new Gson().toJson(dp));
        return dp[n - 1][m - 1];

    }


    public static void main(String[] args) {
        System.out.println(
                solution(
                        new int[][] {
                            {1, 2, 3},
                            {4, 5, 1}
                    }
                )
        );

        System.out.println(
                solution(
                        new int[][] {
                                {5, 1},
                                {4, 5}
                        }
                )
        );

        System.out.println(
                solution(
                        new int[][] {
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15},
                                {16, 17, 18, 19, 20}
                        }
                )
        );

        System.out.println(
                solution(
                        new int[][] {
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {16, 17, 18, 19, 20},
                                {11, 12, 13, 14, 15}
                        }
                )
        );

        System.out.println(
                solution(
                        new int[][] {
                                {1, 2, 3, 4, 5},
                                {16, 17, 18, 19, 20},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15}
                        }
                )
        );

        System.out.println(
                solution(
                        new int[][] {
                                {1, 2, 3, 4, 5},
                                {1, 1, 18, 19, 20},
                                {100000, 1, 8, 9, 10},
                                {11, 12, 13, 14, 15}
                        }
                )
        );
    }
}
