package jiachen.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {
	private boolean[][] state;
	private char[][] grid;
	private Set<String> dictionary;
	
	public Boggle(char[][] grid, Set<String> dictionary) {
		this.grid = grid;
		this.dictionary = dictionary;
		this.state = new boolean[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				state[i][j] = false;
			}
		}
	}
	
	public List<Tuple<Integer,Integer>> getNbr(int x, int y) {
		List<Tuple<Integer, Integer>> nbr = new ArrayList<> ();
		int startx = Math.max(0, x - 1);
		int starty = Math.max(0, y - 1);
		int endx = Math.min(grid.length - 1, x + 1);
		int endy = Math.min(grid.length - 1, y + 1);
		for (int i = startx; i <= endx; i++) {
			for (int j = starty; j <= endy; j++) {
				if (state[i][j]) {
					continue;
				} else {
					nbr.add(new Tuple<Integer,Integer> (i,j));
				}
			}
		}
		return nbr;
	}
	
	public void searchWord_rec(int x, int y, StringBuilder current, HashSet<String> words) {
		if (current.length() > 0 && this.dictionary.contains(current.toString())) {
			words.add(current.toString());
		}
		List<Tuple<Integer,Integer>> nbr = getNbr(x, y);
		for (Tuple<Integer,Integer> pr : nbr) {
			current.append(grid[pr.x][pr.y]);
			state[pr.x][pr.y] = true;
			searchWord_rec(pr.x, pr.y, current, words);
			current.setLength(current.length() - 1);
			state[pr.x][pr.y] = false;
		}
	}
	
	public HashSet<String> searchWord() {
		StringBuilder current = new StringBuilder();
		HashSet<String> words = new HashSet<> ();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				searchWord_rec(i, j, current, words);
			}
		}
		return words;
	}
 }
