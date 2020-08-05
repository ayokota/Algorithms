package practice;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by ayokota on 8/4/20.
 */
public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for(int[] row : matrix)
            Arrays.fill(row, -1);

        right(matrix, 0, 0, 1);
        return matrix;
    }

    public static void right(int[][] matrix, int i, int j, int num) {
        if(j == matrix.length || matrix[i][j] != -1) {
            // j needs to move back
            //check if down is good
            if(!check(matrix, i + 1, j - 1))
                return;
            down(matrix, i + 1, j - 1, num);
        } else {
            matrix[i][j] = num++;
            right(matrix, i, j + 1, num);
        }
    }

    public static void down(int[][] matrix, int i, int j, int num) {
        if(i == matrix.length || matrix[i][j] != -1) {
            // i needs to move back
            //check if left is good
            if(!check(matrix, i - 1, j - 1))
                return;
            left(matrix, i - 1, j - 1, num);
        } else {
            matrix[i][j] = num++;
            down(matrix, i + 1, j, num);
        }
    }

    public static void left(int[][] matrix, int i, int j, int num) {
        if(j < 0 || matrix[i][j] != -1) {
            // j needs to move back
            //check if up is good
            if(!check(matrix, i - 1, j + 1))
                return;
            up(matrix, i - 1, j + 1, num);
        } else {
            matrix[i][j] = num++;
            left(matrix, i, j - 1, num);
        }
    }

    public static void up(int[][] matrix, int i, int j, int num) {
        if(i < 0 || matrix[i][j] != -1) {
            // j needs to move back
            //check if left is good
            if(!check(matrix, i + 1, j + 1))
                return;
            right(matrix, i + 1, j + 1, num);

        } else {
            matrix[i][j] = num++;
            up(matrix, i - 1, j, num);
        }
    }

    public static boolean check(int[][] matrix, int i, int j) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] != -1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(generateMatrix(3)));
    }
}
