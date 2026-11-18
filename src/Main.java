import java.io.IOException;
import java.util.LinkedList;

public class Main {
    static void main() {
        FromFile file = new FromFile("data\\data.txt");

        LinkedList<String> list = new LinkedList<>();
        DirectedGraph G = new DirectedGraph();

        try {
            file.read(list, G);
        } catch (IOException e) {
            IO.println("No read file. " + e);
        }

        DirectedGraphOrders orders = new DirectedGraphOrders(G);
        Iterable<Integer> order = orders.topologicalOrder();

        try {
            file.write(list, order);
        } catch (IOException e) {
            IO.println("Write error. " + e);
        }
    }
}
