package jiachen.algorithm;

public class edge {
	private int weight;
	private boolean visited;
	private vertex src;
	private vertex dest;

	public edge(int weight, boolean visited, vertex src, vertex dest) {
		this.weight = weight;
		this.visited = visited;
		this.src = src;
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public vertex getSrc() {
		return src;
	}

	public void setSrc(vertex src) {
		this.src = src;
	}

	public vertex getDest() {
		return dest;
	}

	public void setDest(vertex dest) {
		this.dest = dest;
	}
}
