import java.util.LinkedList;

public class DirectedGraph {
    private int V;
    private int E;
    private final LinkedList<LinkedList<Integer>> adj;

    public DirectedGraph() {
        this.V = 0;
        this.E = 0;
        adj =  new LinkedList<>();
    }

    public DirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj =  new LinkedList<>();
        for (int v = 0; v < V; v++)
            adj.add(new LinkedList<>());
    }
    public int V() { return V; }
    public int E() {return E; }
    public void addEdge(int v, int w) {
        while(v >= adj.size() || w >= adj.size()){
            adj.add(new LinkedList<>());
        }
        V = adj.size();
        adj.get(v).add(w);
        E++;
    }
    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }
    public DirectedGraph reverse() {
        DirectedGraph R = new DirectedGraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(w, v);
        return R;
    }

    public boolean isEmpty(){
        return V == 0;
    }
}
