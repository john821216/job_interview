package Leetcode;

public class _501 {
	private int[] mod;
	private int curCount = 0;
	private int maxCount = 0;
	private int curVal = 0;
	private int modNumber = 0;

	public int[] findMode(TreeNode root) {
		inorderFindMaxCount(root);
		curCount = 0;
		curVal = 0;
		mod = new int[modNumber];
		modNumber = 0;
		inorderFindMode(root);
		return mod;
	}

	public void findMaxCount(int val) {
		if (val != curVal) {
			curVal = val;
			curCount = 0;
		}
		curCount++;
		if (curCount > maxCount) {
			maxCount = curCount;
			modNumber = 1;
		} else if (curCount == maxCount) {
			modNumber++;
		}
	}

	public void findMode(int val) {
		if (val != curVal) {
			curVal = val;
			curCount = 0;
		}
		curCount++;
		if (curCount == maxCount) {
			mod[modNumber++] = val;
		}
	}
	
	public void inorderFindMode(TreeNode root){
		if (root == null) {
			return;
		}
		inorderFindMode(root.left);
		findMode(root.val);
		inorderFindMode(root.right);
	}

	public void inorderFindMaxCount(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderFindMaxCount(root.left);
		findMaxCount(root.val);
		inorderFindMaxCount(root.right);
	}
}
