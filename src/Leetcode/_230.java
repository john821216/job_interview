package Leetcode;

import java.util.Stack;

public class _230 {
    public int kthSmallest(TreeNode root, int k) {
       Stack<TreeNode> s = new Stack<TreeNode>();
       TreeNode curNode = root;
       while(curNode != null){
    	   		s.add(curNode);
    	   		curNode = curNode.left;
       }
       
       while(!s.isEmpty()){
    	   		TreeNode popNode = s.pop();
    	   		k--;
    	   		if(k ==0){
    	   			return popNode.val;
    	   		}
    	   		if(popNode.right != null){
    	   			popNode = popNode.right;
    	   			while(popNode != null){
    	   				s.add(popNode);
    	   				popNode = popNode.left;
    	   			}
    	   		}
       }
       return -1;
    }

}
