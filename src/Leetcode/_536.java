package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class _536 {
	int curLoc = 0;

	public TreeNode str2tree(String s) {
		if (s.equals("")) {
			return null;
		}
		TreeNode root = new TreeNode(s.charAt(0));
		str2treeHelper(root, s, 1);
		return root;
	}

	public TreeNode str2treeHelper(TreeNode cur,String s, int curLoc) {
		char curC = s.charAt(curLoc);
		TreeNode n = null;;
		if (curC == '(') {
			n = new TreeNode(s.charAt(++curLoc));
			n.left = str2treeHelper(s, ++curLoc);
		} else if(curC ==')') {
			curLoc++;
			return n;
		}
		
		if (curC == '(') {
			n = new TreeNode(s.charAt(++curLoc));
			n.right = str2treeHelper(s, ++curLoc);
		}  else if(curC ==')') {
			curLoc++;
			return n;
		}
		curLoc++;
		return n;
	}
}
