package jiachen.algorithm;

import java.util.ArrayList;
import java.util.List;

public class vertex {
	private int id;
	private char value;
	private boolean visited;
	private List<vertex> adj_vertex;
	private List<vertex> in_vertex;

	public vertex(int id, boolean visited) {
		this.id = id;
		this.visited = visited;
		this.adj_vertex = new ArrayList<> ();
		this.in_vertex = new ArrayList<> ();
	}
	
	public vertex(char value, boolean visited) {
		this.value = value;
		this.visited = visited;
		this.adj_vertex = new ArrayList<> ();
		this.in_vertex = new ArrayList<> ();
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public List<vertex> getAdj_vertex() {
		return adj_vertex;
	}

	public void setAdj_vertex(List<vertex> adj_vertex) {
		this.adj_vertex = adj_vertex;
	}

	public List<vertex> getIn_vertex() {
		return in_vertex;
	}

	public void setIn_vertex(List<vertex> in_vertex) {
		this.in_vertex = in_vertex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
