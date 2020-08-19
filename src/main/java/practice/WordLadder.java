package practice;

import com.google.gson.Gson;

import java.util.*;

/**
 * Created by ayokota on 8/15/20.
 */
public class WordLadder {

    class TreeNode {
        String val;
        TreeNode parent;
        int depth;
        int i;

        public TreeNode(String s, TreeNode parent, int i) {
            val = s;
            this.parent = parent;
            this.i = i;
            if(parent != null)
                depth = parent.depth + 1;
            else
                depth = 1;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        TreeNode node = new TreeNode(beginWord, null, -1);

        findLadders(node, endWord, result, visited, wordList);

        return result;
    }

    public void findLadders(TreeNode node, String endWord, List<List<String>> result, boolean[] visited, List<String> wordList) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int shortestPath = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Queue<TreeNode> newQueue = new LinkedList<>();

            while(!queue.isEmpty()) {
                node = queue.poll();
                if (node.depth > shortestPath)
                    return;

                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i] == true)
                        continue;
                    String word = wordList.get(i);


                    if (isOneDiff(wordList.get(i), node.val)) {
                        if (word.equals(endWord)) {
                            shortestPath = Math.min(shortestPath, node.depth);
                            String[] ladder = new String[node.depth];
                            for (int j = node.depth - 1; j >= 0; j--) {
                                ladder[j] = node.val;
                                node = node.parent;
                            }
                            result.add(Arrays.asList(ladder));
                            break;
                        } else {
                            TreeNode nextNode = new TreeNode(word, node, i);
                            newQueue.add(nextNode);
                        }
                    }
                }
            }
            queue = newQueue;
        }
    }

//    public void findLadders(TreeNode node, String endWord, List<List<String>> result, boolean[] visited, List<String> wordList) {
//        if(node.val.equals(endWord)) {
//
//            String[] ladder = new String[node.depth];
//            for(int i = node.depth - 1; i >= 0; i--) {
//                ladder[i] = node.val;
//                node = node.parent;
//            }
//            result.add(Arrays.asList(ladder));
//            return;
//        } else if(!result.isEmpty() && result.get(0).size() == node.depth)
//            return;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        for(int i = 0; i < wordList.size(); i++) {
//            if(visited[i] == true)
//                continue;
//
//            String word = wordList.get(i);
//            // matches
//            if(isOneDiff(wordList.get(i), node.val)) {
//                TreeNode nextNode = new TreeNode(word, node, i);
//                queue.add(nextNode);
//            }
//        }
//
//        while(!queue.isEmpty()) {
//            TreeNode nextNode = queue.poll();
//            visited[nextNode.i] = true;
//            findLadders(nextNode, endWord, result, visited, wordList);
//            visited[nextNode.i] = false;
//        }
//
//    }

    public boolean isOneDiff(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int numDiff = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                numDiff++;
            if(numDiff > 1)
                return false;
        }
        return numDiff == 1;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();

        System.out.println(
                new Gson().toJson(
                        wl.findLadders(
                                "hit",
                                "cog",
                                Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"})
                        )
                )
        );
    }
}
