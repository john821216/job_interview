package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class _545 {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
		HashSet<TreeNode> h = new HashSet<TreeNode>();
		List<Integer> an = new ArrayList<Integer>();
        if(root==null){
            return an;
        }
		// left
		TreeNode cur = root;
		if (cur.left == null) {
			an.add(cur.val);
			h.add(cur);
		} else {
			an.add(cur.val);
			h.add(cur);
			cur = cur.left;
			an.add(cur.val);
			h.add(cur);
			while (cur.left != null || cur.right != null) {
				if (cur.left == null) {
					cur = cur.right;
				} else {
					cur = cur.left;
				}
				an.add(cur.val);
				h.add(cur);
			}
		}

		inorder(root, an, h);

		cur = root;
		List<Integer> r = new ArrayList<Integer>();
		if (cur.right == null) {
			if (!h.contains(cur)) {
				r.add(cur.val);
                h.add(cur);
			}
		} else {
			cur = cur.right;
			if (!h.contains(cur)) {
				r.add(cur.val);
				h.add(cur);
			}
			while (cur.left != null || cur.right != null) {
				if (cur.right == null) {
					cur = cur.left;
				} else {
					cur = cur.right;
				}
				if (!h.contains(cur)) {
					r.add(cur.val);
					h.add(cur);
				}
			}
		}

		for (int i = r.size() - 1; i >= 0; i--) {
			an.add(r.get(i));
		}
		return an;
	}

	public void inorder(TreeNode cur, List<Integer> l, HashSet<TreeNode> h) {
		if (cur == null) {
			return;
		}
		inorder(cur.left, l, h);
		if (cur.left == null && cur.right == null) {
			if (!h.contains(cur)) {
				l.add(cur.val);
				h.add(cur);
			}
		}
		inorder(cur.right, l, h);
	}
}
