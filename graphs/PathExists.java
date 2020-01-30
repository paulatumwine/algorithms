public class PathExists extends BreadthFirstSearch {

    int counter; // component counter
    boolean pathExists;
    Vertex end;

    public PathExists(Graph graph) {
        super(graph);
        counter = 0;
        pathExists = false;
    }

    @Override
    protected void processVertex(Vertex w) {
        super.processVertex(w);
        if (w.equals(end)) pathExists = true;
    }

    @Override
    protected void additionalProcessing() {
        super.additionalProcessing();
        if (!pathExists) counter++; // increment only if a path hasn't been found in the first component
    }

    public boolean pathExists(Vertex u, Vertex v) {
        this.end = v;
        start(u);
        return counter == 0 && pathExists;
    }

}
