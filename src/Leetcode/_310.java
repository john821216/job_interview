package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _310 {
	public static void main(String[] args) {
		_310 a = new _310();
		a.execute();
	}

	public void execute() {
		int[][] arr = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		findMinHeightTrees(6,arr);
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		LinkedList<Integer>[] l = new LinkedList[n];

		for (int i = 0; i < l.length; i++) {
			l[i] = new LinkedList<Integer>();
		}

		int a = edges.length;
		for (int i = 0; i < a; i++) {
			l[edges[i][0]].add(edges[i][1]);
			l[edges[i][1]].add(edges[i][0]);
		}

		int min = Integer.MAX_VALUE;
		List<Integer> an = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			visited[i] = true;
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[]{i,1});
			int max = Integer.MIN_VALUE;
			while (!q.isEmpty()) {
				int[] pop= q.poll();
				for (int j = 0; j < l[pop[0]].size(); j++) {
					if (!visited[l[pop[0]].get(j)]) {
						visited[l[pop[0]].get(j)] = true;
						q.add(new int[]{l[pop[0]].get(j), pop[1]+1});
						if(pop[1]+1 > max){
							max = pop[1]+1;
						}
					}
				}
			}
			System.out.println(max);
			if (max < min) {
				min = max;
				an = new ArrayList<Integer>();
				an.add(i);
			}

			else if (max == min) {
				an.add(i);
			}
		}
		return an;
	}
}
