package Leetcode;

import java.util.Stack;

public class _84 {
	public static void main(String[] args) {
		_84 a = new _84();
		a.execute();
	}

	public void execute() {
		System.out
				.println(largestRectangleArea2(new int[] { 6,2,5,4,5,1,6 }));
	}

	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0) {
			return 0;
		}

		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			int tempMax = 0;
			for (int j = heights[i]; j >= 1; j--) {
				int width = 0;
				for (int k = i; k < heights.length; k++) {
					if (heights[k] >= j) {
						width++;
					} else {
						break;
					}
				}
				tempMax = Math.max(tempMax, width * j);
			}
			max = Math.max(max, tempMax);
		}
		return max;
	}

	public int largestRectangleArea2(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			System.out.println(s);
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp]
						* (s.isEmpty() ? i : i - 1 - s.peek()));
				if (!s.isEmpty()) {
					System.out.println(height[tp] + " " + i + " "
							+ (i - 1 - s.peek()));
				} else{
					System.out.println(i +"aaa");
				}
				System.out.println("MAXAREA: " + maxArea);
				i--;
			}
		}
		return maxArea;
	}
}
