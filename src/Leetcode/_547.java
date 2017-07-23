package Leetcode;

public class _547 {
	public static void main(String[] args) {
		_547 a = new _547();
		a.execute();

	}

	public void execute() {
		int[][] arr = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(findCircleNum(arr));
	}

	public int findCircleNum(int[][] M) {
		boolean[] isVisited = new boolean[M.length];
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				findCircleNumHelper(i, M, isVisited);
				count++;
			}
		}
		return count;
	}

	public void findCircleNumHelper(int cur, int[][] M, boolean[] isVisited) {
		for (int i = 0; i < M.length; i++) {
			if (i != cur && M[cur][i] == 1 && !isVisited[i]) {
				isVisited[i] = true;
				findCircleNumHelper(i, M, isVisited);
			}
		}
	}

	public int findCircleNum2(int[][] M) {
		int[] parent = new int[M.length];
		int[] size = new int[M.length];
		int count = M.length;
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		for (int i = 0; i < M.length; i++) {
			for (int j = i + 1; j < M.length; j++) {
				if (M[i][j] == 1) {
					if(connected(parent,size,i,j)){
						count--;
					}
				}
			}
		}
		
		return count;

	}

	public boolean connected(int[] parent, int[] size, int p, int q) {
		int pParent = find(parent, p);
		int qParent = find(parent, q);
		if(pParent == qParent) return false;
		if (size[pParent] < size[qParent]) {
			parent[pParent] = qParent;
			size[qParent] += parent[pParent];
		} else {
			parent[qParent] = pParent;
			size[pParent] += parent[qParent];
		}
		return true;
	}

	public int find(int[] parent, int p) {
		if (p == parent[p]) {
			return p;
		} else {
			parent[p] = find(parent, parent[p]);
			return parent[p];
		}
	}

}
