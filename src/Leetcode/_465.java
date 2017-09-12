package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _465 {

	public static void main(String[] args) {
		System.out.println(new _465().minTransfers(new int[][] { { 2, 0, 5 }, { 3, 4, 4 } }));
	}

	public int minTransfers(int[][] transactions) {
		HashMap<Integer, Integer> ppM = new HashMap<Integer, Integer>();

		for (int i = 0; i < transactions.length; i++) {
			int from = transactions[i][0];
			int to = transactions[i][1];
			int sendM = transactions[i][2];
			if (!ppM.containsKey(from)) {
				ppM.put(from, 0);
			}
			ppM.put(from, ppM.get(from) + sendM * -1);

			if (!ppM.containsKey(to)) {
				ppM.put(to, 0);
			}
			ppM.put(to, ppM.get(to) + sendM);
		}

		List<Integer> l = new ArrayList<Integer>();
		for (int i : ppM.values()) {
			if (i != 0) {
				l.add(i);
			}
		}
		int[] debt = new int[l.size()];
		for (int i = 0; i < debt.length; i++) {
			debt[i] = l.get(i);
		}
		for (int i : debt) {
			System.out.print(i);
		}

		int minCount = dfs(l, debt, 0, 0);
		return minCount;
	}

	public int dfs(List<Integer> l, int[] debt, int pos, int count) {
		int start = pos;
		while (start < debt.length && debt[start] == 0) {
			start++;
		}
		if (start == debt.length) {
			return count;
		}
		
		System.out.println(start +" " + pos);
		
		int min = Integer.MAX_VALUE;
		for (int i = start + 1; i < debt.length; i++) {
			if (debt[i] * debt[start] < 0) {
				debt[i] += debt[start];
				min = Math.min(min, dfs(l, debt, start + 1, count + 1));
				debt[i] -= debt[start];
			}
		}
		return min;
	}
}
