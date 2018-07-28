package jiachen.algorithm;

import java.util.Stack;

public class Flowers {
	public static void main(String[] args) {
		Flowers f = new Flowers();
		int[] flowers = new int[] {8,2,5,4,1,6,3,7,9};
		int rst = f.kEmptySlots(flowers, 2);
		System.out.println(rst);
	}
	
	private static class QuickUnion {
		int[] id;
		int[] len;
		
		public QuickUnion(int n) {
			this.id = new int[n];
			this.len = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
				len[i] = 0;
			}
		}
		
		public int union(int i) {
			if (i == 0) {
				int rootR = getRoot(i + 1);
				if (len[rootR] >= 1) {
					len[rootR] += 1;
					id[i] = rootR;
				} else {
					len[i] = 1;
				}
				return Math.max(1, len[rootR]);
			}
			
			if (i == id.length - 1) {
				int rootL = getRoot(i - 1);
				if (len[rootL] >= 1) {
					len[rootL] += 1;
					id[i] = rootL;
				} else {
					len[i] = 1;
				}
				return Math.max(1, len[rootL]);
			}
			
			int rootL = getRoot(i - 1);
			int rootR = getRoot(i + 1);
					
			if (len[rootL] >= len[rootR] && len[rootL] >= 1) {
				len[rootL] += len[rootR] + 1;
				id[rootR] = rootL;
				id[i] = rootL;
			} else if (len[rootR] >= len[rootL] && len[rootR] >= 1) {
				len[rootR] += len[rootL] + 1;
				id[rootL] = rootR;
				id[i] = rootR;
			} else {
				len[i] = 1;
			}
			return Math.max(Math.max(len[rootR], len[rootL]), 1);
		}
		
		private int getRoot(int i) {
			while (i != id[i]) {
				id[i] = id[id[i]];
				i = id[i];
			}
			return i;
		}
	}
	public static int kEmptySlots(int[] flowers, int k) {
		QuickUnion qu = new QuickUnion(flowers.length);
		for (int i = flowers.length - 1; i >= 0; i--) {
			if (flowers[i] == flowers.length || flowers[i] == 1) {
				qu.union(flowers[i] - 1);
			}
			int len = qu.union(flowers[i] - 1);
			if (len == k) {
				return i;
			}
		}
		return -1;
	}
}
