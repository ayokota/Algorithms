package practice;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayokota on 8/9/20.
 */
public class findDuplicates {
    public List<Integer> solution(int[] nums) {
        List<Integer> output_arr = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                output_arr.add(index + 1);
            nums[index] = -nums[index];
        }

        return output_arr;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new findDuplicates().solution(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
    }
}
