package leetcode;

public class _450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null){
			return null;
		}
		if(key < root.val){
			root.left = deleteNode(root.left, key);
		} else if(key > root.val){
			root.right = deleteNode(root.right, key);
		} else{
			if(root.left == null){
				return root.right;
			} else if(root.right == null){
				return root.left;
			} else{
				//find minNode
				TreeNode minNode = findMin(root);
				root.val = minNode.val;
				root.right = deleteNode(root.right, minNode.val);		
			}
		}
		return root;
	}
	
	public TreeNode findMin(TreeNode node){
		TreeNode tNode = node.right;
		while(tNode.left != null){
			tNode = tNode.left;
		}
		return tNode;
	}
}

/**
 * Definition for a binary tree node. 
 * public class TreeNode { 
 * int val; 
 * TreeNode left; 
 * TreeNode right; 
 * TreeNode(int x) { 
 * 	val = x; 
 * } 
 * }
 */
