package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _449 {

	public static void main(String[] args) {
		_449 a = new _449();
		a.execute();
	}

	public void execute() {
		TreeNode r = new TreeNode(5);
		r.left = new TreeNode(3);
		r.right = new TreeNode(6);
		r.left.left = new TreeNode(2);
		// r.right.right = new TreeNode(7);
		serialize(r);
		deserialize("5,3,2,6,");
	}

	private static final String SEP = ",";
	private static final String NULL = "null";

	// Encodes a tree to a single string.
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return NULL;
		}
		StringBuilder s = new StringBuilder();
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode pop = st.pop();
			s.append(pop.val).append(SEP);
			if (pop.right != null) {
				st.push(pop.right);
			}

			if (pop.left != null) {
				st.push(pop.left);
			}
		}
		return s.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    if(data.equals(NULL)){
	        return null;
	    }
		Queue<Integer> l = new LinkedList<Integer>();
		String[] str = data.split(",");
		for (int i = 0; i < str.length; i++) {
			if (!str[i].equals("")) {
				l.add(Integer.valueOf(str[i]));
			}
		}
		TreeNode root = getNode(l);
		return root;
	}

	public TreeNode getNode(Queue<Integer> l) {
		if (l.size() == 0)
			return null;
		TreeNode root = new TreeNode(l.poll());
		Queue<Integer> left = new LinkedList<Integer>();
		while (!l.isEmpty()) {
			if (l.peek() < root.val) {
				left.add(l.poll());
			} else {
				break;
			}
		}
		root.left = getNode(left);
		root.right = getNode(l);
		return root;
	}
}
