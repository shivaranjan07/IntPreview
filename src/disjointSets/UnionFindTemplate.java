package disjointSets;

import java.util.Arrays;

public class UnionFindTemplate {

    public static class UnionFindByRank {
        int[] parent, rank;
        int count;

        public UnionFindByRank(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            // rank of each node will be zero
            for(int i=0;i<n;i++) {
                parent[i]=i; //initially parent of a node will be itself
            }
        }

        // not recommended to use it
        public int findByHalving(int p) {
            while(p != parent[p]) {
                parent[p]=parent[parent[p]];
                p=parent[p];
            }
            printParent();
            return p;
        }

        private void printParent() {
            Arrays.stream(parent).forEach(el -> System.out.print(el + " "));
            System.out.println();
        }

        public int findParent(int p) {
            if(p==parent[p]) {
                return p;
            }
            parent[p] = findParent(parent[p]);
            return parent[p];
        }

        public void unionByRank(int p, int q) {
            int rootP = findParent(p);
            int rootQ = findParent(q);

            if(rootP == rootQ) return; // both have same parent

            if(rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if(rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int getCount() {
            return this.count;
        }
    }

    public static class UnionFindBySize {
        int[] parent, size;
        int count;

        public UnionFindBySize(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for(int i=0;i<n;i++) {
                parent[i]=i;
                size[i]=1;
            }
        }

        public int findParent(int p) {
            if(p==parent[p]) {
                return p;
            }
            parent[p] = findParent(parent[p]);
            return parent[p];
        }

        public void unionBySize(int p, int q) {
            int rootP = findParent(p);
            int rootQ = findParent(q);

            if(rootP == rootQ) return; // both have same parent

            if(size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP]+=size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ]+=size[rootP];
            }
            count--;
        }

    }


    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        //initiate UnionFind class
        UnionFindByRank unionFindByRank = new UnionFindByRank(3);
        for (int i = 0; i < mat.length; ++i)
            for (int j = i; j < mat[i].length; ++j)
                if (mat[i][j] == 1) unionFindByRank.unionByRank(i, j);

        System.out.println("\n"+unionFindByRank.getCount());
    }
}
