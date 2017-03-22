package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. 
 * public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class _267 {
	public static void main(String[] args){
		_267 a = new _267();
		a.execute();
	}
	
	public void execute(){
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(5);
		r.left.left = new TreeNode(3);
		r.left.right= new TreeNode(8);
		r.left.right.left = new TreeNode(10);
		List<String> l = binaryTreePaths(r);
		
		for(int i = 0; i < l.size() ; i++){
			System.out.print(l.get(i) +" ");
		}
		
		System.out.println();
		
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
    		List<String> l = new ArrayList<String>();
    		if(root == null){
    			return l;
    		}
        findPath(l, 	root.val+"" , root);
        return l;
    }
    
    public void findPath(List<String> l, String s, TreeNode n){
    		if(n.right == null && n.left == null){
    			l.add(s);
    		}
    		
    		if(n.left != null){
    			findPath(l , s+"->"+n.left.val, n.left);
    		}
    		
    		if(n.right !=null){
    			findPath(l ,  s+"->"+n.right.val, n.right);
    		}		
    }
}
