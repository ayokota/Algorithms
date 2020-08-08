package practice;

import java.util.*;

/**
 * Created by ayokota on 8/7/20.
 */
public class alienOrder {
    public static String alienOrder(String[] words)
    {

        Map<Character, List<Character>> graph = new HashMap();
        int[] degree = new int[26];
        Set<Character> seen = new HashSet();

        //put all char in words in seen
        for(String word:words)
            for(char c:word.toCharArray())
                seen.add(c);

        //compare chars vertically & build graph
        //also increment degree for the letters that come latter
        for(int i=0;i<words.length-1;i++)
        {
            String curr = words[i];
            String next = words[i+1];
            int min = Math.min(curr.length(),next.length());

            for(int j=0;j<min;j++)
            {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2)
                {
                    List<Character> list = graph.getOrDefault(c1,new ArrayList<>());
                    list.add(c2);
                    graph.put(c1,list);
                    degree[c2-'a']++;
                    break; //stop it here, don't process next character
                }

                //if we reach the end of shorter word && latter is the shorter word
                //this would not be possible as if 2 words from 0 -> i are the same
                //the shorter word has be come first lexicographically
                //IE: taco, tacocat
                if(j==min-1 && curr.length()>min)
                    return "";
            }
        }


        StringBuilder sb = new StringBuilder();


        Queue<Character> queue = new LinkedList();

        //put all degree==0 from seen set into a queue
        //because they arent after any other characters therefore they are in lexicographical order
        for(char c:seen)
            if(degree[c-'a']==0)
                queue.offer(c);


        //kind of like BFS approach here,
        //but with all the degree == 0 char in the queue already
        while(!queue.isEmpty())
        {
            char curr = queue.poll();
            sb.append(curr);
            List<Character> adj = graph.get(curr);
            if(adj!=null && !adj.isEmpty())
            {
                //for all adjacent chars
                //decrement degree
                //add to queue if degree is 0
                for(char node:adj)
                {
                    degree[node-'a']--;
                    if(degree[node-'a']==0)
                        queue.offer(node);
                }
            }
        }

        if(sb.toString().length() != seen.size())
            return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));
    }
}
