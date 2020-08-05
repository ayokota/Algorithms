package practice;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ayokota on 8/5/20.
 */
public class PopularFeatures {

    public static String[] solution(int numFeatures, int topFeatures, String[] possibleFeatures,
                         int numFeatureRequests, String[] featureRequests) {
        Map<String, Integer> numFeatureOccured = new HashMap<>();

        //build numFeatureOccured map
        for(String req : featureRequests) {
            req = req.toLowerCase();
            for(String feature : possibleFeatures) {
                if(req.indexOf(feature) > -1) {
                    int occurance = numFeatureOccured.getOrDefault(feature, 0) + 1;
                    numFeatureOccured.put(feature, occurance);
                }
            }
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> numFeatureOccured.get(b) - numFeatureOccured.get(a));
        String[] result = new String[topFeatures];
        maxHeap.addAll(numFeatureOccured.keySet());

        for(int i = 0; i < topFeatures; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
            new Gson().toJson(
        solution(6,
                2,
                new String[]{"storage", "battery", "hover", "alexa", "waterproof", "solar"},
                7,
                new String[]{
                        "I wish my Kindle had even more Storage!",
                        "I wish the battery life on my Kindle lasted 2 years.",
                        "I read in the bath and would enjoy a waterproof kindle",
                        "Waterproof and increased battery are my top two requests",
                        "I want to take my Kindle into the shower. Waterproof please waterproof !",
                        "It would be neat if my Kindle would hover on my desk when not in use,",
                        "How cool would it be fi my Kindle charged in the sun via solar power?"
                })
            )
        );
    }
}
