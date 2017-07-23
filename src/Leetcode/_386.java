package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _386 {
	public static void main(String[] args) {
		_386 a = new _386();
		a.execute();
	}

	public void execute() {
		lexicalOrder(1);
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			dfs(i, n, l);
		}
		return l;
	}

	public void dfs(int i, int n, List<Integer> l) {
		if (i > n) {
			return;
		} else {
			l.add(i);
			for (int j = 0; j <= 9; j++) {
				if (i * 10 + j > n) {
					return;
				}
				dfs(i * 10 + j, n, l);
			}
		}
	}
}
