package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _652 {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		List<TreeNode> l = new ArrayList<TreeNode>();
		find(root, h, l);
		return l;
	}

	public String find(TreeNode cur, HashMap<String, Integer> h, List<TreeNode> l) {
		if (cur == null) {
			return "#";
		}

		String s = cur.val + "," + find(cur.left, h, l) + find(cur.right, h, l);
		if(!h.containsKey(s)) {
			h.put(s, 0);
		} else {
			h.put(s, h.get(s)+1);
		}
		if(h.get(s)==1) {
			l.add(cur);
		}
		return s;
	}

}
