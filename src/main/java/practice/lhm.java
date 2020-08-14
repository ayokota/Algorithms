package practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ayokota on 8/13/20.
 */
public class lhm {

    public static void main(String[] args){
        Map<Integer, Integer> map;
        map = new LinkedHashMap<Integer, Integer>(3,0.75f,true) {
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer>eldest){
                return size()>3;
            }
        };
    }
}
