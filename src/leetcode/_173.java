package Leetcode;

import java.util.Stack;

public class _173 {
	Stack<TreeNode> s = new Stack<TreeNode>();
	public _173(TreeNode root) {
		TreeNode curN = root;
		while(curN != null){
			s.push(curN);
			curN = curN.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode next = s.pop();
		TreeNode cur;
		if(next.right != null){
			cur = next.right;
			
			while(cur != null){
				s.push(cur);
				cur = cur.left;
			}
		}
		return next.val;
	}
}
