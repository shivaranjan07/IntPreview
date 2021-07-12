package graphs;

import java.util.LinkedList;
import java.util.Queue;

class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat){

        if(mat == null || mat.length == 0) {
            return mat;
        }

        int m=mat.length, n=mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];



        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    vis[i][j]=true;
                }
            }
        }


        final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()) {
            int count = queue.size();
            for(int i=0;i<count;i++) {
                int[] curr = queue.poll();
                int currx = curr[0];
                int curry = curr[1];

                for(int[] d: dir) {
                    int x = currx+d[0];
                    int y=curry+d[1];


                    if(x<0||x>m-1||y<0||y>n-1||vis[x][y]) continue;

                    mat[x][y] = mat[currx][curry]+1;
                    queue.offer(new int[]{x, y});

                    vis[x][y] = true;

                }
            }
        }

        return mat;

    }
}
