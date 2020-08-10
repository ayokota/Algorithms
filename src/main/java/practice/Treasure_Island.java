package practice;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ayokota on 8/10/20.
 */
public class Treasure_Island {
    public int solution(char[][] island) {
        int n = island.length;
        int m = island[0].length;

        int[] currLocation = new int[]{0,0};

        List<int[]> neighbors = new LinkedList<>();
        neighbors.add(currLocation);

        int steps = 0;
        boolean[][] visited = new boolean[n][m];
        while(!neighbors.isEmpty()) {
            List<int[]> newNeighbors = new LinkedList<>();

            for(int[] neighbor : neighbors) {
                int x = neighbor[0];
                int y = neighbor[1];
                if(island[x][y] == 'X')
                    return steps;

                visited[x][y] = true;
                if(isPossiblePath(island, x + 1, y, visited))
                    newNeighbors.add(new int[]{x + 1, y});
                if(isPossiblePath(island, x - 1, y, visited))
                    newNeighbors.add(new int[]{x - 1, y});
                if(isPossiblePath(island, x, y + 1, visited))
                    newNeighbors.add(new int[]{x, y + 1});
                if(isPossiblePath(island, x, y - 1, visited))
                    newNeighbors.add(new int[]{x, y - 1});
            }

            if(newNeighbors.size() > 0)
                steps++;

            neighbors = newNeighbors;
        }


        return steps;
    }

    public boolean isPossiblePath(char[][] island, int x, int y, boolean[][] visited) {
        if(x < 0 || y < 0 || x >= island.length || y >= island[0].length || island[x][y] == 'D' || visited[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) {
        Treasure_Island ti = new Treasure_Island();
        System.out.println(
                ti.solution(new char[][] {
                        {'O', 'O', 'O', 'O'},
                        {'D', 'O', 'D', 'O'},
                        {'O', 'O', 'O', 'O'},
                        {'X', 'D', 'D', 'O'},
                })
        );

        System.out.println(
                ti.solution(new char[][] {
                        {'O', 'O', 'O', 'O'},
                        {'D', 'D', 'D', 'O'},
                        {'O', 'O', 'O', 'O'},
                        {'X', 'D', 'D', 'O'},
                })
        );
    }

}
