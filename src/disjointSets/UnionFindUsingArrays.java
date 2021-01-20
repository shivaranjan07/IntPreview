package disjointSets;

public class UnionFindUsingArrays {
    private int size; // the number of elems in disjoint set
    private int noofcomponents; //the number of components currently in DS
    private int[] sz; //the size of each component;
    private int[] id; //id contains parent of i

    public UnionFindUsingArrays(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException("size must be greater than 0");
        }

        //initially each component will be pointing to themselves
        this.size = this.noofcomponents= size;
        this.sz = new int[this.size];
        this.id = new int[this.size];

        for(int i =0; i< this.size;i++) {
            id[i] = i; //parent of themselves
            sz[i] = 1; //each components originally of size one
        }
    }

    //find which component/set p belongs to
    public int find(int p) {
        //find the root element
        int root = p;
        while(root != id[root]) {
            root = id[root];
        }

        //path compression
        while(p != root) {
            int next = p;
            id[p] = root;
            p = next;
        }

        return root;
    }

    //return whether both p and q belong to sme component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p) {
        return sz[find(p)];
    }

    public int getComponents() {
        return noofcomponents;
    }

    //unify the components/sets containing elements p and q
    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        //these numbers are already in same group
        if(root1 == root2){
            return;
        }

        //merge two components together merge smaller one into larger one
        if(sz[root1] < sz[root2]) {
            sz[root2]+=sz[root1];
            id[root1] = root2;
        } else {
            sz[root1]+=sz[root2];
            id[root2] = root1;
        }

        //reduce the no of components byone, as we know that once we merged one(whole) component with other
        noofcomponents--;
    }
}
