package Leetcode;

import java.util.LinkedList;

public class _207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		LinkedList<Integer> l[] = new LinkedList[numCourses];
		for (int i = 0; i < l.length; i++) {
			l[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			l[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		boolean[] marked = new boolean[numCourses];
		boolean[] onStack = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (!marked[i]) {
				if (!dfs(l, marked, onStack, i)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean dfs(LinkedList<Integer>[] l, boolean[] marked,
			boolean[] onStack, int i) {
		marked[i] = true;
		onStack[i] = true;

		for (int j = 0; j < l[i].size(); j++) {
			if(!marked[l[i].get(j)]){
				if(!dfs(l,marked,onStack,l[i].get(j))){
					return false;
				}
			} else if(onStack[l[i].get(j)]){
				return false;
			}
		}
		onStack[i] = false;
		return true;
	}
}
