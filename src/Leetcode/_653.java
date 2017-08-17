package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _653 {
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> l = new ArrayList<Integer>();
		inorder(root, l);
		int start = 0;
		int end = l.size()-1;
		while(start<end) {
			if(l.get(start)+l.get(end)>k) {
				end--;
			} else if(l.get(start)+l.get(end) < k) {
				start++;
			} else {
				return true;
			}
		}
		return false;
	}

	public void inorder(TreeNode n, List<Integer> l) {
		if(n==null) {
			return;
		}
		inorder(n.left,l);
		l.add(n.val);
		inorder(n.right,l);
	}
}
