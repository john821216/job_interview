package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _655 {
	public static void main(String[] argw) {
		_655 a = new _655();
		a.execute();
	}

	public void execute() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(printTree(root));
	}

	public List<List<String>> printTree(TreeNode root) {
		List<List<String>> ll = new ArrayList<List<String>>();
		int height = getHeight(root);
		int width = (int) (Math.pow(2, height) - 1);
		for (int i = 0; i < height; i++) {
			List<String> l = new ArrayList<String>();
			for (int j = 0; j < width; j++) {
				l.add("");
			}
			ll.add(l);
		}
		print(root, ll, 0, width - 1, 0);
		
		for (int i = 0; i < height; i++) {
			System.out.println(ll.get(i));
		}
		return ll;
	}

	public void print(TreeNode cur, List<List<String>> ll, int start, int to, int curHeight) {
		if (cur == null) {
			return;
		}
		int pos = (start + to) / 2;
		ll.get(curHeight).set(pos, cur.val+"");
		print(cur.left, ll, 0, pos - 1, curHeight + 1);
		print(cur.right, ll, pos + 1, to, curHeight + 1);
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
}
