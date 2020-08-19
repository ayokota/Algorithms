package practice;

import com.google.gson.Gson;

import java.util.*;

/**
 * Created by ayokota on 8/14/20.
 */
public class wordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, Set<String>> wordsMap = new HashMap<>();

        for(String word : words) {
            Set<String> wordList = wordsMap.getOrDefault(word.charAt(0), new HashSet<>());
            wordList.add(word);
            wordsMap.put(word.charAt(0), wordList);
        }

        List<String> result = new LinkedList<>();
        findWords(board, 0, 0, wordsMap, result);

        return result;
    }

    public void findWords(char[][] board, int i, int j, Map<Character, Set<String>> wordsMap, List<String> result) {
        char c = board[i][j];
        if(wordsMap.keySet().contains(c)) {

            //find words
            Iterator<String> itr = wordsMap.get(c).iterator();
            while(itr.hasNext()) {
                String word = itr.next();
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(exists(board, i, j, word, 0, visited)) {
                    result.add(word);
                    itr.remove();
                }
            }

            if(wordsMap.get(c).size() == 0)
                wordsMap.remove(c);
        }

        //to right
        if(isValid(board, i, j + 1))
            findWords(board, i, j + 1, wordsMap, result);
        //to down
        if(isValid(board, i + 1, j))
            findWords(board, i + 1, j, wordsMap, result);

    }

    public boolean exists(char[][] board, int i, int j, String word, int wordI, boolean[][] visited) {
        if(wordI + 1 == word.length() && board[i][j] == word.charAt(wordI))
            return true;
        else if(board[i][j] != word.charAt(wordI))
            return false;
        visited[i][j] = true;

        char c = word.charAt(wordI + 1);

        //up
        if(isValid(board, i - 1, j, c, visited) && exists(board, i - 1, j, word, wordI + 1, visited))
            return true;
        //down
        if(isValid(board, i + 1, j, c, visited) && exists(board, i + 1, j, word, wordI + 1, visited))
            return true;
        //left
        if(isValid(board, i, j - 1, c, visited) && exists(board, i, j - 1, word, wordI + 1, visited))
            return true;
        //left
        if(isValid(board, i, j + 1, c, visited) &&  exists(board, i, j + 1, word, wordI + 1, visited))
            return true;

        return false;
    }

    public boolean isValid(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length)
            return false;

        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char c, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != c || visited[i][j] == true)
            return false;

        return true;
    }

    public static void main(String[] args) {
        wordSearch ws = new wordSearch();

//        char[][] board = new char[][]{
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };
//
//        System.out.println(
//                new Gson().toJson(
//                        ws.findWords(board, new String[] {"oath","pea","eat","rain"})
//                )
//        );
//
//        char[][] board2 = new char[][]{
//                {'a','a'}
//        };
//        System.out.println(
//                new Gson().toJson(
//                        ws.findWords(board2, new String[] {"aaa"})
//                )
//        );

        char[][] board3 = new char[][]{
                {'a','b'},
                {'a','a'}
        };
        System.out.println(
                new Gson().toJson(
                        ws.findWords(board3, new String[] {"aaba"})
                )
        );
    }

}
