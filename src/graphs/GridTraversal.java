package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GridTraversal {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1} };

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    findConnectedComponents(grid, i, j, vis);
                    count++;
                }
            }
        }
        System.out.println("connected components "+count);

        int grid1[][] = { { 1, 2, 3, 4 },
                          { 5, 6, 7, 8 },
                          { 9, 10, 11, 12 },
                          { 13, 14, 15, 16 } };

        boolean[][] vis1 = new boolean[grid1.length][grid1[0].length];

        bfs(grid1, vis1, 0, 0);

    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] dx1 = new int[] { -1, 0, 1, 0 };
    static int[] dy1 = new int[] { 0, 1, 0, -1 };
    private static void bfs(int[][] grid1, boolean[][] vis1, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        vis1[x][y] = true;

        while(!queue.isEmpty()) {
            Pair cell = queue.poll();

            int adjX = cell.first;
            int adjY = cell.second;

            System.out.print(grid1[adjX][adjY] + " ");

            for(int i=0;i<dx1.length;i++) {
                int newX = adjX+dx1[i];
                int newY = adjY+dy1[i];
                if(isValid1(newX, newY, vis1, grid1)) {
                    queue.add(new Pair(newX, newY));
                    vis1[newX][newY] = true;
                }
            }
        }
    }

    private static boolean isValid1(int x, int y, boolean[][] vis1, int[][] grid1) {
        if(x < 0 || x>=grid1.length || y < 0 || y >= grid1[0].length || vis1[x][y]) {
            return false;
        }
        return true;
    }

    static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
    private static void findConnectedComponents(int[][] grid, int x, int y, boolean[][] vis) {
        vis[x][y] = true;

        for(int i=0;i<dx.length;i++) {
            int adjX = x+dx[i];
            int adjY = y+dy[i];
            if(isValid(adjX, adjY, vis, grid)) {
                findConnectedComponents(grid, adjX, adjY, vis);
            }
        }
    }

    private static boolean isValid(int x, int y, boolean[][] vis, int[][] grid) {
        return x >= 0 && x <= grid.length-1 && y >= 0 && y <= grid[0].length-1 && !vis[x][y] && grid[x][y] != 0;
    }




}
