import java.util.HashMap;


public class ShortestPath extends BreadthFirstSearch {
	private HashMap<Vertex, Integer> levelsMap = new HashMap<Vertex, Integer>();
	private HashMap<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();

	/** Assumes g is connected */
	public ShortestPath(Graph g) {
		super(g);

	}

	@Override
	protected void processEdge(Edge e) {
		super.processEdge(e);
		parentMap.put(e.u, e.v);
		levelsMap.put(e.u, levelsMap.get(e.v) + 1);
	}

	public int computeShortestPathLength(Vertex s, Vertex v) {
		parentMap.put(s, s);
		levelsMap.put(s, 0);
		start(s);
		return levelsMap.get(v);
	}
}
