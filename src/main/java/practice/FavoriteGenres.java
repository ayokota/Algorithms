package practice;

import java.util.*;

/**
 * Created by ayokota on 8/4/20.
 */
public class FavoriteGenres {
    public static Map<String, List<String>> solution(Map<String, List<String>> userSongs,
                                                     Map<String, List<String>> songGenres) {
        Map<String, List<String>> result = new HashMap<>();

        Map<String, String> songToGenreMap = new HashMap<>();
        for(String genre : songGenres.keySet()) {
            for(String song : songGenres.get(genre)) {
                songToGenreMap.put(song, genre);
            }
        }

        for(String user : userSongs.keySet()) {
            Map<String, Integer> genreCount = new HashMap<>();

            //calculate genre count for a user
            for(String song : userSongs.get(user)) {
                String genre = songToGenreMap.get(song);
                if(genre == null)
                    continue;
                int count = genreCount.getOrDefault(genre, 0) + 1;
                genreCount.put(genre, count);
            }

            if(genreCount.size() == 0) {
                result.put(user, new LinkedList<>());
                continue;
            }

            //get most fav
            PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> genreCount.get(b) - genreCount.get(a));
            maxHeap.addAll(genreCount.keySet());
            List<String> gens = new LinkedList<>();

            int mostListenedCount = genreCount.get(maxHeap.peek());
            while(!maxHeap.isEmpty()) {
                if(mostListenedCount > genreCount.get(maxHeap.peek()))
                    break;
                gens.add(maxHeap.poll());
            }
            result.put(user, gens);

        }
        return result;
    }

    public static void testCase1() {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> result = solution(userSongs, songGenres);

        for(String user : result.keySet()) {
            System.out.println(user);
            for(String genre : result.get(user))
                System.out.print(genre + ", ");
            System.out.println();
        }

    }

    public static void testCase2() {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        Map<String, List<String>> songGenres = new HashMap<>();

        Map<String, List<String>> result = solution(userSongs, songGenres);

        for(String user : result.keySet()) {
            System.out.println(user);
            for(String genre : result.get(user))
                System.out.print(genre + ", ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        testCase1();


    }
}
