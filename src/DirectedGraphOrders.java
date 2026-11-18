import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraphOrders {
    private final boolean[] marked;
    private final Queue<Integer> pre;
    private final Stack<Integer> reversePost;

    private final boolean isDAG;

    public DirectedGraphOrders(DirectedGraph G) {
        CycleDetector cyclefinder = new CycleDetector(G);
        isDAG = !cyclefinder.hasCycle();

        pre = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }
    private void dfs(DirectedGraph G, int v) {
        pre.add(v);
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
        reversePost.push(v);
    }

    //orders
    public Iterable<Integer> reversePostOrder() {
        return reversePost;
    }
    public Iterable<Integer> postOrder() {
        return reversePost.reversed();
    }
    public Iterable<Integer> preOrder() {
        return pre;
    }

    // topological order
    public Iterable<Integer> topologicalOrder() {
        if (isDAG()) {
            return reversePostOrder();
        }
        return null;
    }
    public boolean isDAG() {
        return isDAG;
    }
}
