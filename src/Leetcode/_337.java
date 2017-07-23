package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _337 {

	public int rob(TreeNode root) {
		HashMap<TreeNode, Integer> h = new HashMap<TreeNode, Integer>();
		return robHelper(h, root);
	}

	public int robHelper(HashMap<TreeNode, Integer> h, TreeNode cur) {
		int val = 0;
		if (cur == null)
			return 0;
		if (h.containsKey(cur))
			return h.get(cur);
		if (cur.left != null) {
			val = robHelper(h, cur.left.left) + robHelper(h, cur.left.right);
		}

		if (cur.right != null) {
			val = robHelper(h, cur.right.left) + robHelper(h, cur.right.right);
		}

		val = Math.max(val + cur.val,
				robHelper(h, cur.left) + robHelper(h, cur.right));
		h.put(cur, val);
		return val;
	}

	public int rob2(TreeNode root) {
		int[] an = robHelper2(root);
		return Math.max(an[0], an[1]);
	}

	public int[] robHelper2(TreeNode cur) {
		if(cur == null){
			return new int[2];
		}
		int[] left = robHelper2(cur.left);
		int[] right = robHelper2(cur.right);

		int[] ret = new int[2];
		ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		ret[1] = cur.val + left[0] + right[0];
		return ret;
	}
}
