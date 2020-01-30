public class HasCycle extends BreadthFirstSearch {

	int counter;
	public HasCycle(Graph graph) {
		super(graph);
		counter = 0;
	}

	protected void processEdge(Edge e) {
		counter++;
	}

	public boolean hasCycle() {
		start();
//		return graph.getSpanningTree().edges.size() < graph.edges.size();
		return counter < graph.edges.size();
	}

}
