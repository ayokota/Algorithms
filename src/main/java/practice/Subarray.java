package practice;

/**
 * Created by ayokota on 8/4/20.
 */
public class Subarray {

    public static int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        return countWithAtMostDistinct(A,K)-countWithAtMostDistinct(A,K-1);
    }

    public static int countWithAtMostDistinct(int[] A, int K){
        if(K==0)
            return 0;
        int ans = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int[] occur = new int[A.length+1];
        while(right < A.length){
            if(occur[A[right]]==0)
                cnt++;
            while(cnt > K ){
                occur[A[left]]--;
                if (occur[A[left]] == 0)
                    cnt--;
                left++;
            }
            occur[A[right]]++;
            ans = ans + right-left+1;
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }
}
