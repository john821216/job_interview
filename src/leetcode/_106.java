package Leetcode;

public class _106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTreeHelper(postorder.length - 1, 0, inorder.length - 1,
				inorder, postorder);
	}

	public TreeNode buildTreeHelper(int postOrderIdx, int start, int end,
			int[] inorder, int[] postorder) {
		if (start > end) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postOrderIdx]);
		int index = findIdxInOrder(postorder[postOrderIdx], inorder);
		root.left = buildTreeHelper(postOrderIdx - (end - index + 1), start,
				index - 1, inorder, postorder);
		root.right = buildTreeHelper(postOrderIdx - 1, index + 1, end, inorder,
				postorder);
		return root;
	}

	public int findIdxInOrder(int val, int[] inorder) {
		int idx = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val) {
				idx = i;
				break;
			}
		}
		return idx;
	}
}
