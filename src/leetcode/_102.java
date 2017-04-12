package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return ll;
        q.add(root);
        while(!q.isEmpty()){
        		List<Integer> l = new ArrayList<Integer>();
        		int size = q.size();
        		for(int i = 0 ; i< size ; i++){
        			TreeNode nextPoll = q.poll();
        			l.add(nextPoll.val);
        			if(nextPoll.left != null){
        				q.add(nextPoll.left);
        			}
        			if(nextPoll.right != null){
        				q.add(nextPoll.right);
        			}
        		}
        	
        		ll.add(l);
        }
        return ll;
    }
}
