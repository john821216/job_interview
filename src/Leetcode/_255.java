package Leetcode;

import java.util.Stack;

public class _255 {
	public static void main(String[] args) {
		_255 a = new _255();
		a.execute();
	}

	public void execute() {
		System.out.println(verifyPreorder(new int[] { 2, 1 }));
	}

	public boolean verifyPreorder(int[] preorder) {
		int min = Integer.MIN_VALUE;
		Stack<Integer> s = new Stack<Integer>();
		for (int val : preorder) {
			if(val < min) {
				return false;
			}
			while(!s.isEmpty() && val > s.peek()) {
				min =  s.pop();
			}
			s.push(val);
		}
		return true;
	}

}
