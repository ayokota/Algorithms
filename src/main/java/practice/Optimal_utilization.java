package practice;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ayokota on 8/10/20.
 */
public class Optimal_utilization {

    public List<int[]> solution(int[][] a, int[][] b, int target) {
        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        Arrays.sort(b, (x, y) -> x[1] - y[1]);

        if(a[a.length - 1][1] > b[b.length - 1][1])
            return solution(b, a, target, false);
        else
            return solution(a, b, target, true);
    }

    public List<int[]> solution(int[][] a, int[][] b, int target, boolean correctOrder) {
        if(a[a.length - 1][1] > b[b.length - 1][1])
            return solution(b, a, target);

        List<int[]> results = new LinkedList<>();
        //a is smaller
        //b is larger
        int indexA = 0;
        int indexB = b.length - 1;

        int highest = 0;

        while(indexA < a.length && indexB > -1) {
            int sum = a[indexA][1] + b[indexB][1];
            //too large, move b smaller
            if(sum > target) {
                indexB--;
            } else {
                if(sum > highest) {
                    results = new LinkedList<>();
                    highest = sum;
                }

                if(sum >= highest) {
                    if (correctOrder)
                        results.add(new int[]{a[indexA][0], b[indexB][0]});
                    else
                        results.add(new int[]{b[indexB][0], a[indexA][0]});
                }
                indexA++;
            }
        }



        return results;
    }

    public static void main(String[] args) {
        Optimal_utilization optimal_utilization = new Optimal_utilization();
        System.out.println(new Gson().toJson(
                optimal_utilization.solution(
                        new int[][] {{1, 2}, {2, 4}, {3, 6}},
                        new int[][] {{1, 2}},
                        7
                )
        ));

        System.out.println(new Gson().toJson(
                optimal_utilization.solution(
                        new int[][] {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
                        new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                        10
                )
        ));

        System.out.println(new Gson().toJson(
                optimal_utilization.solution(
                        new int[][] {{1, 8}, {2, 7}, {3, 14}},
                        new int[][] {{1, 5}, {2, 10}, {3, 14}},
                        20
                )
        ));

        System.out.println(new Gson().toJson(
                optimal_utilization.solution(
                        new int[][] {{1, 8}, {2, 15}, {3, 9}},
                        new int[][] {{1, 8}, {2, 11}, {3, 12}},
                        20
                )
        ));
    }
}
