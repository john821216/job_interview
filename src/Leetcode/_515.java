package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> l = new ArrayList<Integer>();
        if(root == null) return l;
        q.add(root);
        int num = 1;
        while(!q.isEmpty()){
            int nextN = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < num ; i++){
                TreeNode n = q.poll();
                if(n.val > max){
                    max = n.val;
                }
                if(n.left != null){
                    q.add(n.left);
                    nextN++;
                } 
                
                if(n.right != null){
                    q.add(n.right);
                    nextN++;
                }
            }
            num = nextN;
            l.add(max);
        }
        return l;
    }
}
