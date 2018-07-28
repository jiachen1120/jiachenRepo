package jiachen.algorithm;

import java.util.HashMap;

public class CloneGraph {
	public static GraphNode clone_rec(GraphNode root, HashMap<GraphNode, GraphNode> visited) {
		if (root == null) {
			return null;
		}
		GraphNode pNew = new GraphNode(root.data);
		visited.put(root, pNew);
		for (GraphNode p : root.neighbors) {
			GraphNode x = visited.get(p);
			if (x == null) {
				pNew.neighbors.add(clone_rec(p, visited));
			} else {
				pNew.neighbors.add(x);
			}
		}
		return pNew;
	}
	public static GraphNode clone(GraphNode root) {
		HashMap<GraphNode, GraphNode> visited = new HashMap<> ();
		return clone_rec(root, visited);
 	}
}
