package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _314 {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		HashMap<Integer, List<Integer>> h = new HashMap<Integer, List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> lv = new LinkedList<Integer>();
		List<Integer> l = new ArrayList<Integer>();
		int min = 0;
		int max = 0;
		l.add(root.val);
		q.add(root);
		lv.add(0);
		h.put(0, l);
		while (!q.isEmpty()) {
			TreeNode poll = q.poll();
			int curLc = lv.poll();
			if (poll.left != null) {
				if (!h.containsKey(curLc - 1)) {
					l = new ArrayList<Integer>();
				} else {
					l = h.get(curLc - 1);
				}
				l.add(poll.left.val);
				h.put(curLc - 1, l);
				q.add(poll.left);
				lv.add(curLc - 1);
				min = Math.min(curLc - 1, min);
			}

			if (poll.right != null) {
				if (!h.containsKey(curLc + 1)) {
					l = new ArrayList<Integer>();
				} else {
					l = h.get(curLc + 1);
				}
				l.add(poll.right.val);
				h.put(curLc + 1, l);
				q.add(poll.right);
				lv.add(curLc + 1);
				max = Math.max(curLc + 1, max);
			}
		}

		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		for (int i = min; i <= max; i++) {
			ll.add(h.get(i));
			System.out.println(h.get(i));
		}
		return ll;
	}
}
