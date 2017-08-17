package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _297 {
	private static final String SPLITER = ",";
	private static final String NN = "N";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb  = new StringBuilder("");
		buildString(sb,root);
		return sb.toString();
	}
	
	public void buildString(StringBuilder sb, TreeNode n) {
		if(n==null) {
			sb.append(NN).append(SPLITER);
		} else {
			sb.append(n.val).append(SPLITER);
			buildString(sb,n.left);
			buildString(sb,n.right);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> q = new LinkedList<String>();
		String[] dataStr = data.split(SPLITER);
		for(int i = 0 ; i < dataStr.length ; i++) {
			q.add(dataStr[i]);
		}
		return buildTree(q);
	}
	
	public TreeNode buildTree(Queue<String> q ) {
		String val = q.remove();
		if(val.equals(NN)) {
			return null;
		} else {
			TreeNode n = new TreeNode(Integer.valueOf(val));
			n.left = buildTree(q);
			n.right = buildTree(q);
			return n;
		}
	}
}
