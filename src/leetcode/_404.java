package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _404 {
	public int sumOfLeftLeaves(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null)
			return 0;
		q.add(root);
		int sum = 0;
		while (!q.isEmpty()) {
			TreeNode pop = q.poll();
			if (pop.left != null) {
				if (pop.left.left == null && pop.left.right == null) {
					sum += pop.left.val;
				}
				q.add(pop.left);
			}
			if (pop.right != null) {
				q.add(pop.right);
			}
		}
		return sum;
	}

	public int sumOfLeftLeaves2(TreeNode root) {
		int cur = 0;

		if (root == null) {
			return 0;
		}
		
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				cur += root.left.val;
			} else {
				cur += sumOfLeftLeaves(root.left);
			}
		}

		cur += sumOfLeftLeaves(root.right);
		return cur;
	}
}
