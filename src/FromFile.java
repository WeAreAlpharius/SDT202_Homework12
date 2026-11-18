import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Scanner;

public class FromFile {
    private final Path path;

    public FromFile(String filaName){
        path = Path.of(filaName);
    }

    public void write(LinkedList<String> map, Iterable<Integer> order) throws IOException {
        LinkedList<String> save = new LinkedList<>();

        for (int i : order) {
            save.add((map.get(i)) + " ");
        }

        Files.write(Path.of("data\\out.txt"), save);
    }

    public void read(LinkedList<String> list, DirectedGraph graph) throws IOException {
        Scanner sc;
        list.clear();

        sc = new Scanner(path);

        while (sc.hasNext())
        {
            String from = sc.next();
            String to = sc.next();

            if(!list.contains(from)) list.add(from);
            if(!list.contains(to)) list.add(to);

            int indexFrom = list.indexOf(from);
            int indexTo = list.indexOf(to);

            graph.addEdge(indexFrom, indexTo);
        }
    }

}
