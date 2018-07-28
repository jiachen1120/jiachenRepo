package jiachen.algorithm;

import java.util.ArrayList;
import java.util.List;

public class WeightGraph {
	private List<vertex> g;
	private List<edge> e;
	public WeightGraph(List<vertex> g, List<edge> e) {
		this.g = g;
		this.e = e;
	}
	public List<vertex> getG() {
		return g;
	}
	public void setG(List<vertex> g) {
		this.g = g;
	}
	public List<edge> getE() {
		return e;
	}
	public void setE(List<edge> e) {
		this.e = e;
	}
	public vertex vertex_exist(int id) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getId() == id) {
				return g.get(i);
			}
		}
		return null;
	}
	public void generate(int vertices, List<ArrayList<Integer>> edges) {
		for (int i = 0; i < vertices; i++) {
			vertex v = new vertex(i + 1, false);
			g.add(v);
		}
		
		for (int i = 0; i < edges.size(); i++) {
			vertex src = vertex_exist(edges.get(i).get(1));
			vertex dest = vertex_exist(edges.get(i).get(2));
			edge e = new edge(edges.get(i).get(0), false, src, dest);
			getE().add(e);
		}
	}
	public int findMST() {
		int vertices_count = 0;
		int weight = 0;
		
		vertex current = g.get(0);
		current.setVisited(true);
		vertices_count++;
		
		while (vertices_count < g.size()) {
			edge smallest = null;
			for (int i = 0; i < e.size(); i++) {
				if (e.get(i).isVisited() == false 
						&& e.get(i).getSrc().isVisited() == true 
						&& e.get(i).getDest().isVisited() == false) {
					smallest = e.get(i);
					break;
				}
			}
			for (int i = 0; i < e.size(); i++) {
				if (e.get(i).isVisited() == false
						&& e.get(i).getSrc().isVisited() == true
						&& e.get(i).getDest().isVisited() == false
						&& e.get(i).getWeight() < smallest.getWeight()) {
					smallest = e.get(i);
				}
			}
			smallest.setVisited(true);
			smallest.getDest().setVisited(true);
			weight += smallest.getWeight();
			vertices_count++;
		}
		return weight;
	}
}
