package practice;

import com.google.gson.Gson;

import java.util.*;

/**
 * Created by ayokota on 8/19/20.
 */
public class shortestDistance {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dp = new int[maze.length][maze[0].length];

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[start[0]][start[1]] = 0;


        Map<int[], List<int[]>> neighbors = bfs(maze, start);
        System.out.println(new Gson().toJson(neighbors));

        return 0;
    }

    public Map<int[], List<int[]>> bfs(int[][] maze, int[] start) {
        Map<int[], List<int[]>> neighbors = new HashMap<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Queue<int[]> newQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                int[] node = queue.poll();
                if(visited[node[0]][node[1]] == true)
                    continue;

                visited[node[0]][node[1]] = true;
                List<int[]> neighborList = new LinkedList<>();

                int[] up = up(maze, start);
                if(!equals(node, up)) {
                    newQueue.add(up);
                    neighborList.add(up);
                }

                int[] down = down(maze, start);
                if(!equals(node, down)) {
                    newQueue.add(down);
                    neighborList.add(down);
                }

                int[] left = left(maze, start);
                if(!equals(node, left)) {
                    newQueue.add(left);
                    neighborList.add(left);
                }

                int[] right = right(maze, start);
                if(!equals(node, right)) {
                    newQueue.add(right);
                    neighborList.add(right);
                }

                neighbors.put(node, neighborList);
            }

            queue = newQueue;
        }

        return neighbors;
    }

    public int[] up(int[][] maze, int[] start) {
        int i = start[0];
        int j = start[1];
        if(i < 0 || maze[i][j] == 1)
            return new int[]{i + 1, j};
        return up(maze, new int[]{i - 1, j});
    }

    public int[] down(int[][] maze, int[] start) {
        int i = start[0];
        int j = start[1];
        if(i >= maze.length || maze[i][j] == 1)
            return new int[]{i - 1, j};
        return down(maze, new int[]{i + 1, j});
    }

    public int[] left(int[][] maze, int[] start) {
        int i = start[0];
        int j = start[1];
        if(j < 0 || maze[i][j] == 1)
            return new int[]{i, j + 1};
        return left(maze, new int[]{i, j - 1});
    }

    public int[] right(int[][] maze, int[] start) {
        int i = start[0];
        int j = start[1];
        if(j >= maze[0].length || maze[i][j] == 1)
            return new int[]{i, j - 1};
        return right(maze, new int[]{i, j + 1});
    }

    public boolean equals(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public static void main(String[] args) {
        shortestDistance sd = new shortestDistance();
        sd.shortestDistance(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        },
                new int[]{0, 4},
                new int[]{4, 4}
                );
    }
}
