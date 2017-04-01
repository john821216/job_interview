package leetcode;

public class _105 {
	// 1
	// / \
	// 2 3
	// / \ /
	// 4 5 6
	public static void main(String[] args){
		_105 a = new _105();
		a.execute();
	}
	
	public void execute(){
		int[] i = {4,2,5,1,6,3};
		int[] p = {1,2,4,5,3,6};
		TreeNode r = buildTree(p,i);
	}
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// preorder:124536
		// inorder :425163
		return buildTreeHelp(0,0,preorder.length-1,preorder,inorder);
	}

	public TreeNode buildTreeHelp(int preIndex, int start, int end,
			int[] preorder, int[] inorder) {
		if(start > end){
			return null;
		}
		TreeNode n = new TreeNode(preorder[preIndex]);
		int index = search(inorder, n.val);
		n.left = buildTreeHelp(preIndex+1, start, index-1,preorder,inorder);
		n.right = buildTreeHelp(preIndex+ index-start+1,index+1, end,preorder,inorder);
		return n;
	}

	public int search(int[] inorder, int target) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
