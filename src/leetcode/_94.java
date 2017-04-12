package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> l  = new ArrayList<Integer>();
		inorder(l, root);
		return l;
	}
	
	public void inorder(List<Integer> l, TreeNode root){
		if(root == null) return;
		inorder(l, root.left);
		l.add(root.val);
		inorder(l, root.right);
	}
}
