package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144 {
	public static void main(String[] args) {
		_144 a = new _144();
		a.execute();
	}

	public void execute() {
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		n.right = new TreeNode(3);
		n.left.left = new TreeNode(4);
		n.left.right = new TreeNode(5);
		n.left.right.left = new TreeNode(6);
		n.left.right.right = new TreeNode(7);
		n.right.right = new TreeNode(8);
		List<Integer> an = preorderTraversal(n);

		for (int i = 0; i < an.size(); i++) {
			System.out.print(an.get(i) + " ");
		}
		System.out.println();
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		preorderTraversalHelper2(l, root);
		return l;
	}

	// recursive
	public void preorderTraversalHelper(List<Integer> l, TreeNode root) {
		if (root != null) {
			l.add(root.val);
			preorderTraversalHelper(l, root.left);
			preorderTraversalHelper(l, root.right);
		}
	}

	// iterative
	public void preorderTraversalHelper2(List<Integer> l, TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null) {
			s.add(root);
			l.add(root.val);
			root = root.left;
		}
		
		while(!s.isEmpty()){
			TreeNode pS = s.pop();
			if(pS.right != null){
				pS = pS.right;
				
				while(pS != null){
					s.add(pS);
					l.add(pS.val);
					pS = pS.left;
				}
			}
		}
	}

}
