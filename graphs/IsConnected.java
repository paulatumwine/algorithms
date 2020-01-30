public class IsConnected extends BreadthFirstSearch {

	int counter;

	public IsConnected(Graph graph) {
		super(graph);
		counter = 0;
	}

	@Override
	protected void additionalProcessing() {
		super.additionalProcessing();
		counter++;
	}

	public boolean isConnected() {
		start();
		return counter == 1;
	}
}
