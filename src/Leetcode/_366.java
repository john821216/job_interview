package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _366 {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		findLeavesHelper(ll, root);
		return ll;
	}

	public int findLeavesHelper(List<List<Integer>> ll, TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftLv = findLeavesHelper(ll, root.left);
		int rightLv = findLeavesHelper(ll, root.right);
		
		int lv = Math.max(leftLv, rightLv) + 1;
		if(ll.size() < lv) {
			ll.add(new ArrayList<Integer>());
		}
		ll.get(lv-1).add(root.val);
		return lv;
	}
}
