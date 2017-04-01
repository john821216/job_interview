package leetcode;

public class _112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return hasPathSum(root, 0, sum);
	}

	public boolean hasPathSum(TreeNode n, int curS, int sum) {
		curS = curS + n.val;
		if (n.left == null && n.right == null) {
			return curS == sum;
		} else if (n.left != null && n.right == null) {
			return hasPathSum(n.left, curS, sum);
		} else if (n.left == null && n.right != null) {
			return hasPathSum(n.right, curS, sum);
		} else {
			return hasPathSum(n.left, curS, sum)
					|| hasPathSum(n.right, curS, sum);
		}
	}

	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		return hasPathSum2(root.left, sum - root.val)
				|| hasPathSum2(root.right, sum - root.val);
	}
}
