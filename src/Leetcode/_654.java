package Leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class _654 {
	public static void main(String[] args) {
		_654 a = new _654();
		a.execute();
	}

	public void execute() {
		constructMaximumBinaryTree(new int[] { 1,2,3 });
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		for (int i : nums) {
			TreeNode t = new TreeNode(i);
			if (s.isEmpty()) {
				s.push(t);
				continue;
				
			}
			if (!s.isEmpty() && s.peek().val > i) {
				s.peek().right = t;
				s.push(t);
			} else {
				TreeNode n = null;
				while (!s.isEmpty() && s.peek().val < i) {
					n = s.pop();
				}
				t.left = n;
				if (!s.isEmpty()) {
					s.peek().right = t;
				}
				s.push(t);
			}
		}
		return s.firstElement();
	}
}
