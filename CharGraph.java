package jiachen.algorithm;

import java.util.List;

public class CharGraph {
	private List<vertex> g;

	public CharGraph(List<vertex> g) {
		this.g = g;
	}

	public List<vertex> getG() {
		return g;
	}

	public void setG(List<vertex> g) {
		this.g = g;
	}

	public vertex vertex_exist(char value) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getValue() == value) {
				return g.get(i);
			}
		}
		return null;
	}

	public void createGraph(List<String> words_list) {
		for (int i = 0; i < words_list.size(); i++) {
			String word = words_list.get(i);
			char startChar = word.charAt(0);
			char endChar = word.charAt(word.length() - 1);

			vertex start = vertex_exist(startChar);
			if (start == null) {
				start = new vertex(startChar, false);
				g.add(start);
			}

			vertex end = vertex_exist(endChar);
			if (end == null) {
				end = new vertex(endChar, false);
				g.add(end);
			}

			start.getAdj_vertex().add(end);
			end.getIn_vertex().add(start);
		}
	}

	public boolean allVisited() {
		for (int i = 0; i < g.size(); i++) {
			if (!g.get(i).isVisited()) {
				return false;
			}
		}
		return true;
	}

	public boolean out_equal_in() {
		for (int i = 0; i < g.size(); i++) {
			int out = g.get(i).getAdj_vertex().size();
			int in = g.get(i).getIn_vertex().size();
			if (out != in) {
				return false;
			}
		}
		return true;
	}

	public boolean checkCycle_rec(vertex node, vertex startNode) {
		node.setVisited(true);
		List<vertex> adj = node.getAdj_vertex();
		if (allVisited()) {
			for (int i = 0; i < adj.size(); i++) {
				if (adj.get(i) == startNode) {
					return true;
				}
			}
		}

		for (int i = 0; i < adj.size(); i++) {
			if (adj.get(i).isVisited() == false) {
				node = adj.get(i);
				if (checkCycle_rec(node, startNode)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkCycle(List<String> wordList) {
		if (wordList.size() < 2) {
			return false;
		}
		if (g.size() > 0) {
			if (out_equal_in()) {
				return checkCycle_rec(g.get(0), g.get(0));
			}
		}
		return false;
	}
}