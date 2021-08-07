package graphs;

class Node {
    int u;
    int v;
    int weight;

    Node(int u, int v, int weight) {
        this.u=u;
        this.v = v;
        this.weight = weight;
    }

    int getU() { return this.u; }

    int getV() {
        return this.v;
    }

    int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "u=" + u +
                ", v=" + v +
                ", weight=" + weight +
                '}';
    }
}
