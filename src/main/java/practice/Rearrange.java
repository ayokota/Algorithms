package practice;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ayokota on 8/5/20.
 */
public class Rearrange {
    public static List<List<String>> solution(String[] input) {
        List<List<String>> result = new LinkedList<>();

        helper(input, 0, input.length, result);

        return result;
    }

    public static void helper(String[] input, int l, int r, List<List<String>> result) {
        if(l == r) {
            List<String> subResult = new ArrayList<>(input.length);
            for(int i = 0; i < input.length; i++) {
                subResult.add(input[i]);
            }
            result.add(subResult);
        } else {
            for(int i = l; i < r; i++) {
                swap(input, l, i);
                helper(input, l + 1, r, result);
                swap(input, l, i);
            }
        }
    }

    public static void swap(String[] input, int i, int j) {
        String temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(solution(new String[]{"a", "b", "c", "d", "e"}).size()));
    }
}
