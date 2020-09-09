package practice;

import java.util.*;

/**
 * Created by ayokota on 8/19/20.
 */
public class shortestDistance {
    class Pair{
        int score;
        int[] coord;

        public Pair(int score, int[] coord) {
            this.score = score;
            this.coord = coord;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dp = new int[maze.length][maze[0].length];

//        for(int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }

//        dp[start[0]][start[1]] = 0;


//        Map<String, List<int[]>> neighbors = bfs(maze, start, destination);
////        System.out.println(new Gson().toJson(neighbors));
//
//        boolean[][] visited = new boolean[maze.length][maze[0].length];
//        dfs(start, destination, neighbors, dp, visited, 0);
//
//        return dp[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dp[destination[0]][destination[1]] ;
        return dijkstra(maze, start, destination);
    }

    public int dijkstra(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.score - b.score);
        minHeap.add(new Pair(0, start));

        while(!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            if(equals(pair.coord, destination)) {
                return pair.score;
            }

            int[] node = pair.coord;

            int[] up = up(maze, node, 0);
            if(up[2] > 0) {

                minHeap.add(new Pair(up[2] + pair.score, up));
            }

            int[] down = down(maze, node, 0);
            if(down[2] > 0) {
                minHeap.add(new Pair(down[2] + pair.score, down));
            }

            int[] left = left(maze, node, 0);
            if(left[2] > 0) {
                minHeap.add(new Pair(left[2] + pair.score, left));
            }

            int[] right = right(maze, node, 0);
            if(right[2] > 0) {
                minHeap.add(new Pair(right[2] + pair.score, right));
            }

        }
        return -1;
    }

    public void dfs(int[] start, int[] destination, Map<String, List<int[]>> neighbors, int[][] dp, boolean[][] visited, int dist) {

        if(equals(start, destination)) {
            return;
        }


        String nodeStr = toString(start);

        for(int[] neighbor : neighbors.get(nodeStr)) {
            int i = neighbor[0];
            int j = neighbor[1];
            if(visited[i][j] == true) {
                continue;
            }

            int distance = neighbor[2];
            int newDist = distance + dist;
            dp[i][j] = Math.min(dp[i][j], newDist);
            visited[i][j] = true;
            dfs(neighbor, destination, neighbors, dp, visited, dp[i][j]);
            visited[i][j] = false;
        }
    }

    public int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public Map<String, List<int[]>> bfs(int[][] maze, int[] start, int[] destination) {
        Map<String, List<int[]>> neighbors = new HashMap<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Queue<int[]> newQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                int[] node = queue.poll();
                if(equals(node, destination))
                    return neighbors;

                if(visited[node[0]][node[1]] == true)
                    continue;

                visited[node[0]][node[1]] = true;
                List<int[]> neighborList = new LinkedList<>();

                int[] up = up(maze, node, 0);
                if(up[2] > 0) {
                    newQueue.add(up);
                    neighborList.add(up);
                }

                int[] down = down(maze, node, 0);
                if(down[2] > 0) {
                    newQueue.add(down);
                    neighborList.add(down);
                }

                int[] left = left(maze, node, 0);
                if(left[2] > 0) {
                    newQueue.add(left);
                    neighborList.add(left);
                }

                int[] right = right(maze, node, 0);
                if(right[2] > 0) {
                    newQueue.add(right);
                    neighborList.add(right);
                }

                neighbors.put(toString(node), neighborList);
            }

            queue = newQueue;
        }

        return neighbors;
    }

    public String toString(int[] node) {
        return new StringBuilder().append(node[0]).append(":").append(node[1]).toString();
    }

    public int[] up(int[][] maze, int[] start, int distance) {
        int i = start[0];
        int j = start[1];
        if(i < 0 || maze[i][j] == 1)
            return new int[]{i + 1, j, distance - 1};
        return up(maze, new int[]{i - 1, j}, distance + 1);
    }

    public int[] down(int[][] maze, int[] start, int distance) {
        int i = start[0];
        int j = start[1];
        if(i >= maze.length || maze[i][j] == 1)
            return new int[]{i - 1, j, distance - 1};
        return down(maze, new int[]{i + 1, j}, distance + 1);
    }

    public int[] left(int[][] maze, int[] start, int distance) {
        int i = start[0];
        int j = start[1];
        if(j < 0 || maze[i][j] == 1)
            return new int[]{i, j + 1, distance - 1};
        return left(maze, new int[]{i, j - 1}, distance + 1);
    }

    public int[] right(int[][] maze, int[] start, int distance) {
        int i = start[0];
        int j = start[1];
        if(j >= maze[0].length || maze[i][j] == 1)
            return new int[]{i, j - 1, distance - 1};
        return right(maze, new int[]{i, j + 1}, distance + 1);
    }

    public boolean equals(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public static void main(String[] args) {
        shortestDistance sd = new shortestDistance();
        System.out.println(
        sd.shortestDistance(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        },
                new int[]{0, 4},
                new int[]{4, 4}
                )
        );
    }
}
