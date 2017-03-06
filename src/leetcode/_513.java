package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _513 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(findBottomLeftValue(root));
	}

	public static int findBottomLeftValue(TreeNode root) {
		int an = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode popNode = q.poll();
				if( i == 0){
					an = popNode.val;
				}
		
				if (popNode.left != null)
					q.add(popNode.left);
				if (popNode.right != null)
					q.add(popNode.right);
			}
		}

		return an;
	}
}

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
