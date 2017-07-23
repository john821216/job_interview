package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _113 {
	public static void main(String[] args){
		_113 a = new _113();
		a.execute();
	}
	
	public void execute(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		pathSum(root, 22);
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		pathSumHelper(ll, l, root, 0, sum);
		return ll;
	}

	public void pathSumHelper(List<List<Integer>> ll, List<Integer> l,
			TreeNode root, int cur, int sum) {
		cur += root.val;
		l.add(root.val);
		if (root.left == null && root.right == null) {
			if (cur == sum) {
				ll.add(new ArrayList<Integer>(l));
				for(int i :l){
					System.out.print(i +" ");
				}
				System.out.println();
			}
		}
		if (root.left != null) {
			pathSumHelper(ll, l, root.left, cur, sum);
		}

		if (root.right != null) {
			pathSumHelper(ll, l, root.right, cur, sum);

		}
		l.remove(l.get(l.size() - 1));
	}
}
