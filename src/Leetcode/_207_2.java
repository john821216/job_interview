package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _207_2 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		LinkedList<Integer> l[] = new LinkedList[numCourses];
		int edgeCount = prerequisites.length;
		Queue<Integer> q = new LinkedList<Integer>();
		int[] incomingEdges = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			l[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			l[prerequisites[i][1]].add(prerequisites[i][0]);
			incomingEdges[prerequisites[i][0]]++;
		}
		
		for(int i = 0 ; i < incomingEdges.length ; i++){
			if(incomingEdges[i] == 0){
				q.add(i);
			}
		}
		
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int i = 0 ; i < l[cur].size(); i++){
				edgeCount--;
				incomingEdges[l[cur].get(i)]--;
				if(incomingEdges[l[cur].get(i)]==0){
					q.add(l[cur].get(i));
				}
			}
		}
		return edgeCount == 0;
	}
}
