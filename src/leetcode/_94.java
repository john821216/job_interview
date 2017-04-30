package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		inorder(l, root);
		return l;
	}

	public void inorder(List<Integer> l, TreeNode root) {
		if (root == null)
			return;
		inorder(l, root.left);
		l.add(root.val);
		inorder(l, root.right);
	}

	// iterative
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();

		TreeNode cur = root;
		if (cur == null) {
			return l;
		} 
		
		while(cur != null){
			s.add(cur);
			cur = cur.left;
		}
		
		while(!s.isEmpty()){
			cur = s.pop();
			l.add(cur.val);
			cur = cur.right;
			
			while(cur != null){
				s.add(cur);
				cur = cur.left;
			}
		}
		return l;

	}
}
