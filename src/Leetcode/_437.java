package Leetcode;

public class _437 {
	int count = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		pathSumHelper(root, root.val, sum);
		if (root.left != null) {
			pathSum(root.left, sum);
		}
		if (root.right != null) {
			pathSum(root.right, sum);
		}

		return count;
	}

	public void pathSumHelper(TreeNode root, int curSum, int target) {
		if (curSum == target) {
			count++;
		}
		if (root.left != null) {
			pathSumHelper(root.left, curSum + root.left.val, target);
		}

		if (root.right != null) {
			pathSumHelper(root.right, curSum + root.right.val, target);
		}

	}

	public int pathSum2(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		return pathSumHelper2(root, root.val, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
	}

	public int pathSumHelper2(TreeNode root, int curSum, int target) {
		int rootval = 0;
		int leftval = 0;
		int rightval = 0;
		if (curSum == target) {
			rootval = 1;
		}

		if (root.left != null) {
			leftval = pathSumHelper2(root.left, root.left.val + curSum, target);
		}

		if (root.right != null) {
			rightval = pathSumHelper2(root.right, root.right.val + curSum, target);
		}
		
		return rootval + leftval + rightval;
	}

}
