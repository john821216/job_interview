package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class _103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		if (root == null) {
			return ll;
		}
		int number = 1;
		boolean isEven = false;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> l = new ArrayList<Integer>();
			int n = number;
			number = 0;
			for (int i = 0; i < n; i++) {
				TreeNode popN = q.poll();
				if (popN.left != null) {
					q.add(popN.left);
					number++;
				}
				if (popN.right != null) {
					q.add(popN.right);
					number++;
				}
				if (isEven) {
					s.add(popN);
				} else {
					l.add(popN.val);
				}
			}

			if (isEven) {
				while (!s.isEmpty()) {
					l.add(s.pop().val);
				}
			}
			ll.add(l);
			isEven = !isEven;
		}
		return ll;
	}

	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		travel(ll, 1, root);
		return ll;
	}

	public void travel(List<List<Integer>> ll, int level, TreeNode n) {
		if (n != null) {
			if (ll.size() < level) {
				ll.add(new ArrayList<Integer>());
			}

			List<Integer> curLv = ll.get(level-1);
			if (level % 2 == 0) {
				curLv.add(0,n.val);
			} else {
				curLv.add(n.val);
			}
			
			travel(ll, level+1, n.left);
			travel(ll, level+1, n.right);
		}
	}

}
