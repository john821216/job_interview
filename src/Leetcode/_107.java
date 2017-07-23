package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		if (root == null)
			return ll;
		q.add(root);
		int number = 1;
		while (!q.isEmpty()) {
			List<Integer> l = new ArrayList<Integer>();
			int n = number;
			number = 0;
			for (int i = 0; i < n; i++) {
				TreeNode pop = q.poll();
				l.add(pop.val);
				if (pop.left != null) {
					q.add(pop.left);
					number++;
				}
				if (pop.right != null) {
					q.add(pop.right);
					number++;
				}
				System.out.println(n);
			}
			ll.add(0, l);

		}
		return ll;
	}
}
