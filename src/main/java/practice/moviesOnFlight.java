package practice;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by ayokota on 8/8/20.
 */
public class moviesOnFlight {
    public static int[] solution(int[] movieDuration, int flightDuration) {
        flightDuration -= 30;
        Arrays.sort(movieDuration);

        int l = 0, r = movieDuration.length - 1;

        int largest = 0;
        int[] largestPair = new int[]{-1, -1};
        while(l < r) {
            int sum = movieDuration[l] + movieDuration[r];
            if(sum > flightDuration) { // too large, right move left
                r--;
            } else if(sum <= flightDuration) {
                if(sum > largest) {
                    largest = sum;
                    largestPair[0] = l;
                    largestPair[1] = r;
                }
                l++;
            }
        }
        if(largestPair[0] == -1)
            return new int[]{};

        return new int[]{movieDuration[largestPair[0]], movieDuration[largestPair[1]]};
    }

    public static void main(String[] args) {
        System.out.println(
          new Gson().toJson(
                  solution(new int[]{90, 85, 75, 60, 120, 150, 125},
                          250)
          )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{90, 85, 75, 60, 155, 150, 125},
                                250)
                )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{90, 85, 75, 60, 120, 110, 110, 150, 125},
                                250)
                )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{95, 85, 75, 60, 120, 110, 110, 150, 125},
                                250)
                )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{1, 10, 25, 35, 60},
                                90)
                )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{20, 50, 40, 25, 30, 10},
                                90)
                )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{5, 55, 40, 20, 30, 30},
                                90)
                )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{90, 85, 75, 60, 155, 150, 125},
                                250)
                )
        );

        System.out.println(
                new Gson().toJson(
                        solution(new int[]{254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944},
                                230)
                )
        );
    }
}

