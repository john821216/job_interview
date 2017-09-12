package Leetcode;

public class _270 {
	Double minDistance = null;
	int closestValue;

	public int closestValue(TreeNode root, double target) {
		closestValueHelper(root, target);
		return closestValue;
	}

	public void closestValueHelper(TreeNode root, double target) {
		if (root == null) {
			return;
		}
		if (target > (double) root.val) {
			double dis = target - (double) root.val;
			if (minDistance == null) {
				minDistance = dis;
				closestValue = root.val;
			} else {
				if (dis < minDistance) {
					minDistance = dis;
					closestValue = root.val;
				}
			}
			closestValueHelper(root.right, target);
		} else {
			double dis = (double) root.val - target;
			if (minDistance == null) {
				minDistance = dis;
				closestValue = root.val;
			} else {
				if (dis < minDistance) {
					minDistance = dis;
					closestValue = root.val;
				}
			}
			closestValueHelper(root.left, target);

		}
	}

}
