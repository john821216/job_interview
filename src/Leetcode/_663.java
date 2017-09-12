package Leetcode;

public class _663 {
	int totalSum = 0;
	boolean find = false;

	public boolean checkEqualTree(TreeNode root) {
		inorder(root);
		if (totalSum % 2 != 0) {
			return false;
		}
        checkEqualTreeHelper(root);
		return find;
	}

	public void inorder(TreeNode cur) {
		if (cur == null) {
			return;
		}
		inorder(cur.left);
		totalSum += cur.val;
		inorder(cur.right);

	}

	public int checkEqualTreeHelper(TreeNode root) {
		int left =0;
        int right =0;
        if(root.left!=null){
            left = checkEqualTreeHelper(root.left);
            if (totalSum - left == left) {
			    find = true;
		    }
        }
        if(root.right!=null){
            right = checkEqualTreeHelper(root.right);
            if (totalSum - right == right) {
			    find = true;
		    }   
        }
		return left+right+root.val;
	}
}
