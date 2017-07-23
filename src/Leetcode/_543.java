package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _543 {
	int max;

	// for follow up
	int maxL;
	int maxR;
	TreeNode maxNode;

	public static void main(String[] args) {
		_543 a = new _543();
		a.execute();
	}

	public void execute() {
		// 1
		// / \
		// 2 3
		// / \
		// 4 5
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(3);
		r.left.left = new TreeNode(4);
		r.left.right = new TreeNode(5);
		// System.out.println(diameterOfBinaryTree(r));
		getLongestPath(r);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxDiameter(root);
		return max;
	}

	// follow up
	public List<List<String>> getLongestPath(TreeNode root) {
		if (root == null) {
			return null;
		}

		maxDiameter(root);
		List<String> l_str = new ArrayList<String>();
		List<String> r_str = new ArrayList<String>();
		List<Integer> l_i = new ArrayList<Integer>();
		List<Integer> r_i = new ArrayList<Integer>();
		DFS(l_str, l_i, maxNode.left, maxL - 1);
		DFS(r_str, r_i, maxNode.right, maxR - 1);

		List<List<String>> an = new ArrayList<List<String>>();

		for (int i = 0; i < l_str.size(); i++) {
			for (int j = 0; j < r_str.size(); j++) {
				List<String> l = new ArrayList<String>();
				l.add(l_str.get(i).toString() + maxNode.val
						+ r_str.get(j).toString());
				System.out.println(l_str.get(i).toString() + maxNode.val
						+ r_str.get(j).toString());
			}
		}
		return an;
	}

	public int maxDiameter(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxDiameter(root.left);
		int right = maxDiameter(root.right);

		if (left + right > max) {
			max = left + right;
			maxL = left;
			maxR = right;
			maxNode = root;
		}
		return Math.max(left, right) + 1;
	}

	public void DFS(List<String> str, List<Integer> l, TreeNode root, int height) {

		if (root == null) {
			return;
		} else {
			l.add(0, root.val);
		}
		if (height == 0) {
			String add ="";
			for(int i : l){
				add += i+"";
			}			
			str.add(add);

		} else {
			DFS(str, l, root.left, height - 1);
			l.remove(0);
			DFS(str, l, root.right, height - 1);
			l.remove(0);
		}
	}

}
