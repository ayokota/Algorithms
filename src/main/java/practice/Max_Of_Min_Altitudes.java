package practice;

/**
 * Created by ayokota on 8/5/20.
 */
public class Max_Of_Min_Altitudes {


    public static int solution(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] opt = new int[m][n];
        opt[0][0] = Integer.MAX_VALUE;  //very important
        grid[m-1][n-1] = Integer.MAX_VALUE;

        //opt[i][j] = Min(Max(opt[i-1][j], opt[i][j-1]), grid[i][j]）
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 && j==0) continue;
                int upper = i==0 ? Integer.MIN_VALUE : opt[i-1][j];
                int left = j==0 ? Integer.MIN_VALUE : opt[i][j-1];
                opt[i][j] = Math.min(grid[i][j], Math.max(upper, left));
            }
        }
        return opt[m-1][n-1];
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
