package jiachen.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	public int data;
	public List<GraphNode> neighbors = new ArrayList<> ();
	public GraphNode(int data) {
		this.data = data;
	}
}
