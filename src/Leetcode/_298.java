package Leetcode;

public class _298 {
	
	public static void main(String[] args) {
		_298 a = new _298();
		a.execute();
	}
	
	public void execute() {
		TreeNode r = new TreeNode(3);
		r.left = new TreeNode(2);
		r.left.left =  new TreeNode(3);
		r.right = new TreeNode(4);

		System.out.println(longestConsecutive(r));
	}
	int globalMax = 0;

	public int longestConsecutive(TreeNode root) {
		longestConsecutiveHelper(root);
		return globalMax;

	}
	
	public int longestConsecutiveHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = longestConsecutiveHelper(root.left);
		int right = longestConsecutiveHelper(root.right);
		System.out.println(root.val +" "+ left +" " +right +" t");

		if (root.left == null) {
			left = 1;
		} else {
			if (root.val + 1 == root.left.val) {
				left += 1;
			} else {
				left = 1;
			}
		}

		if (root.right == null) {
			right = 1;
		} else {
			if (root.val + 1 == root.right.val) {
				right += 1;
			} else {
				right = 1;
			}
		}
		globalMax = Math.max(Math.max(left, right), globalMax);
		System.out.println(root.val +" "+ left +" " +right);
		return Math.max(left, right);
	}
}
