package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _95 {
	public static void main(String[] args){
		_95 a = new _95();
		a.execute();
	}
	
	public void execute(){
		generateTrees(3);
	}
	
	public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
		return generateTreesHelper(1, n);
	}

	public List<TreeNode> generateTreesHelper(int from, int end) {
		List<TreeNode> re = new ArrayList<TreeNode>();
		if(from > end){
			re.add(null);
			return re;
		}
		for (int i = from; i <= end; i++) {
			// as root;
			List<TreeNode> left = generateTreesHelper(from, i - 1);
			List<TreeNode> right = generateTreesHelper(i + 1, end);
				
			for (int le = 0; le < left.size(); le++) {
				for (int r = 0; r < right.size(); r++) {
				    TreeNode root = new TreeNode(i);
					root.left = left.get(le);
					root.right = right.get(r);
					re.add(root);
				}
			}
		}
		return re;
	}
}
