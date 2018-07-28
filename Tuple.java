package jiachen.algorithm;

public class Tuple<S1, S2> {
	public S1 x;
	public S2 y;

	public Tuple(S1 x, S2 y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
