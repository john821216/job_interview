package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _116 {
	public void connect(TreeLinkNode root) {
		int num = 1;
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		if (root != null)
			q.add(root);
		while (!q.isEmpty()) {
			TreeLinkNode cur = q.poll();
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
			for (int i = 0; i < num - 1; i++) {
				TreeLinkNode next = q.poll();
				if (next.left != null)
					q.add(next.left);
				if (next.right != null)
					q.add(next.right);
				cur.next = next;
				cur = next;
			}
			cur.next = null;
			num *= 2;
		}
	}
	
	public void connect2(TreeLinkNode root) {
        if(root == null) return;
		while(root.left != null){
			TreeLinkNode curNode = root;
			while(curNode != null){
    		    curNode.left.next = curNode.right;
    			if(curNode.next != null){
    				curNode.right.next = curNode.next.left;
    			}
    			curNode = curNode.next;
			}
			root = root.left;
		}
	}

	// Definition for binary tree with next pointer.
	private class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
