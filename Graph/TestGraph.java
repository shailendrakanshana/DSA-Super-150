public class TestGraph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.AddEdge(1, 2, 2);
        g.AddEdge(1, 4, 5);
        g.AddEdge(1, 5, 3);
        g.AddEdge(2, 3, 4);
        g.AddEdge(3, 4, 8);
        g.AddEdge(4, 5, 10);
        System.out.println(g.noofEdges());
        // g.Display();
        // g.RemoveEdge(1, 4);
        // g.Display();
        // g.RemoveVertex(1);
        g.Display();
        System.out.println(g.hasPath(2, 5));
        g.PrintAllPath(2, 5);
    }
}
