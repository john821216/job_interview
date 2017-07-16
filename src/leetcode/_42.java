package Leetcode;

public class _42 {
	public static void main(String[] args) {
		_42 a = new _42();
		a.execute();
	}

	public void execute() {
		System.out
				.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

	public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int trapArea = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			if (height[left] <= height[right]) {
				trapArea += leftMax - height[left];
				left++;
			} else {
				trapArea += rightMax - height[right];
				right--;
			}
		}
		return trapArea;
	}
}
