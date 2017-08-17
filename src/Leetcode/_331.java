package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _331 {
	public boolean isValidSerialization(String preorder) {
		Queue<String> q = new LinkedList<String>();
		q.addAll(Arrays.asList(preorder.split(",")));
		return valid(q) && q.isEmpty();
	}

	public boolean valid(Queue<String> q) {
		if (q.isEmpty()) {
			return false;
		}
		String remove = q.remove();
		if (remove.equals("#")) {
			return true;
		}
		return valid(q) && valid(q);
	}
}
