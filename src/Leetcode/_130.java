package Leetcode;

public class _130 {
	public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < n; i++) {
			dfs(board, 0, i);
			dfs(board, m - 1, i);
		}

		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '*') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	public void dfs(char[][] board, int x, int y) {
		if (board[x][y] != 'O')
			return;
		board[x][y] = '*';

		if (x - 1 > 0) {
			dfs(board, x - 1, y);
		}
		if (x + 1 < board.length) {
			dfs(board, x + 1, y);
		}
		if (y - 1 > 0) {
			dfs(board, x, y - 1);
		}
		if (y + 1 < board[0].length) {
			dfs(board, x, y + 1);
		}
	}

	// use union and find
	public void solve2(char[][] board) {
        if(board.length == 0){
             return;
        }
		int m = board.length;
		int n = board[0].length;
		DisjointSet d = new DisjointSet(m * n + 1);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
					if (board[i][j] == 'O') {
						d.connect(i * n + j, m * n);
					}
				} else {
					if (board[i][j] == 'O') {
						if (board[i - 1][j] == 'O') {
							d.connect(i * n + j, (i - 1) * n + j);
						}
						if (board[i + 1][j] == 'O') {
							d.connect(i * n + j, (i + 1) * n + j);
						}
						if (board[i][j - 1] == 'O') {
							d.connect(i * n + j, i * n + j - 1);
						}
						if (board[i][j + 1] == 'O') {
							d.connect(i * n + j, i * n + j + 1);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j]=='O' && !d.isConnected(i*n+j, n*m)) {
					board[i][j] = 'X';
				}
			}
		}
	}

	private class DisjointSet {
		int[] parent;
		int[] size;

		public DisjointSet(int n) {
			parent = new int[n];
			size = new int[n];
            for(int i = 0 ;i < n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
		}

		public boolean isConnected(int a, int b) {
			return find(a) == find(b);
		}

		public int find(int a) {
			if (a == parent[a]) {
				return a;
			}

			parent[a] = find(parent[a]);
			return parent[a];
		}

		public void connect(int a, int b) {
			int pA = find(a);
			int pB = find(b);
			if (pA == pB) {
				return;
			}
			if (size[pA] < size[pB]) {
				size[pB] += size[pA];
				parent[pA] = pB;
			} else {
				size[pA] += size[pB];
				parent[pB] = pA;
			}
		}
	}
}
