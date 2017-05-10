package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _508 {
	int maxSum;
	HashMap<Integer, Integer> h;

	public int[] findFrequentTreeSum(TreeNode root) {
		h = new HashMap<Integer, Integer>();
		findFrequentTreeSumHelper(root);
		Set<Integer> s = h.keySet();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int key : s) {
			int value = h.get(key);
			if (value == maxSum) {
				a.add(key);
			}
		}

		int[] an = new int[a.size()];
		for (int i = 0; i < an.length; i++) {
			an[i] = a.get(i);
		}
		return an;

	}

	public int findFrequentTreeSumHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		root.val = findFrequentTreeSumHelper(root.left)
				+ findFrequentTreeSumHelper(root.right) + root.val;
		if (h.get(root.val) == null) {
			h.put(root.val, 1);
			maxSum = Math.max(1, maxSum);
		} else {
			h.put(root.val, h.get(root.val) + 1);
			maxSum = Math.max(h.get(root.val), maxSum);
		}
		return root.val;
	}
	
}
