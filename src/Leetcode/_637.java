package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637 {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> an = new ArrayList<Double>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int lvCount = 1;
		int tempLvCount = 1;
		while (!q.isEmpty()) {
			lvCount = tempLvCount;
			tempLvCount = 0;
			double val = 0;
			for (int i = 0; i < lvCount; i++) {
				TreeNode pop = q.poll();
				val += (double) pop.val;
				if (pop.left != null) {
					q.add(pop.left);
					tempLvCount++;
				}
				if (pop.right != null) {
					q.add(pop.right);
					tempLvCount++;
				}
			}
			an.add(val/(double)lvCount);
		}
		return an;
	}
}
