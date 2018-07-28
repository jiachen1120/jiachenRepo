package jiachen.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Graph {
	public static ArrayList<GraphNode> creatUndirectedGraph(int vertices_count, int edges_count) {
		ArrayList<GraphNode> vertices = new ArrayList<> ();
		for (int i = 0; i < vertices_count; i++) {
			vertices.add(new GraphNode(i));
		}
		List<Tuple<Integer, Integer>> edges = new ArrayList<> ();
		for (int i = 0; i < vertices_count; i++) {
			for (int j = i + 1; j < vertices_count; j++) {
				edges.add(new Tuple<Integer, Integer> (i, j));
			}
		}
		Collections.shuffle(edges);
		for (int i = 0; i < edges_count && i < edges.size(); i++) {
			Tuple<Integer, Integer> edge = edges.get(i);
			vertices.get(edge.x).neighbors.add(vertices.get(edge.y));
			vertices.get(edge.y).neighbors.add(vertices.get(edge.x));
		}
		return vertices;
	}
	
	public static void print_rec(GraphNode root, HashSet<GraphNode> visited) {
		if (root == null || visited.contains(root)) {
			return;
		}
		visited.add(root);
		System.out.print(root.data + ": {");
		for (GraphNode n : root.neighbors) {
			System.out.print(n.data + " ");
		}
		System.out.println("}");
		for (GraphNode n : root.neighbors) {
			print_rec(n, visited);
		}
	}
	
	public static void print(GraphNode root) {
		HashSet<GraphNode> visited = new HashSet<> ();
		print_rec(root, visited);
	}
	
	public static boolean isEqual_rec(GraphNode root1, GraphNode root2, HashSet<GraphNode> visited) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.neighbors.size() != root2.neighbors.size()) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		for (GraphNode nbr1 : root1.neighbors) {
			boolean found = false;
			for (GraphNode nbr2 : root2.neighbors) {
				if (nbr1.data == nbr2.data) {
					if (!visited.contains(nbr1)) {
						visited.add(nbr1);
						return isEqual_rec(nbr1, nbr2, visited);
					}
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}
	public static boolean isEqual(GraphNode root1, GraphNode root2) {
		HashSet<GraphNode> visited = new HashSet<> ();
		return isEqual_rec(root1, root2, visited);
	}
}
